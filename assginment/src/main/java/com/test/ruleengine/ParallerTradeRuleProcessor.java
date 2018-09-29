package com.test.ruleengine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import com.test.approver.Approver;
import com.test.approver.ApproverFactory;
import com.test.approver.ApproverType;
import com.test.approvertask.FundAndAnalystApproverTask;
import com.test.fund.TradeFund;

public class ParallerTradeRuleProcessor implements TradeRuleProcessor<TradeFund> {
	// will contain all the approver which need to be executed serially.
	private static Set<ApproverType> serialApproverSet = new LinkedHashSet<>();
	// will contain parraler Approvers
	private static Set<ApproverType> parallelApprover = new HashSet<>();
	private static ParallerTradeRuleProcessor parraleRuleEngine = null;

	private ParallerTradeRuleProcessor() {
		serialApproverSet.add(ApproverType.DIVISON_HEAD);
		serialApproverSet.add(ApproverType.OPERATIONS);

		parallelApprover.add(ApproverType.RESEACRH_ANALYST);
		parallelApprover.add(ApproverType.FUNDMANAGER);
	}

	/**
	 * Will Call Approvers to get Approval and complete the flow
	 */
	@Override
	public void processAndGetTradeApproval(TradeFund tradeFund) {

		CountDownLatch latch = new CountDownLatch(parallelApprover.size());
		for (ApproverType approverType : parallelApprover) {
			FundAndAnalystApproverTask approverTask = new FundAndAnalystApproverTask(latch, tradeFund, approverType);
			new Thread(approverTask).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			tradeFund.setInterMediateFailure(true);
		}
		Iterator<ApproverType> approvetItr = serialApproverSet.iterator();
		while (approvetItr.hasNext() && !tradeFund.isIntermediateFailure()) {
			ApproverType approverType = approvetItr.next();
			Approver<TradeFund> approver = ApproverFactory.getApprover(approverType);
			boolean approved = approver.approveFundRequest(tradeFund);
			if (!approved) {
				tradeFund.setInterMediateFailure(true);
			} else {
				System.out.println("Approved By:" + approverType);
			}
		}
		if (!tradeFund.isIntermediateFailure()) {
			System.out.println("FundDistributed");
		}
	}

	public static TradeRuleProcessor<TradeFund> getInstance() {
		if (null == parraleRuleEngine) {
			synchronized (ParallerTradeRuleProcessor.class) {
				if (null == parraleRuleEngine) {
					parraleRuleEngine = new ParallerTradeRuleProcessor();
				}
			}
		}
		return parraleRuleEngine;
	}

}
