package com.test.approvertask;

import java.util.concurrent.CountDownLatch;

import com.test.approver.Approver;
import com.test.approver.ApproverFactory;
import com.test.approver.ApproverType;
import com.test.fund.TradeFund;

public class FundAndAnalystApproverTask implements Runnable {

	private CountDownLatch latch = null;
	private TradeFund tradefund = null;
	private ApproverType approverType = null;

	public FundAndAnalystApproverTask(CountDownLatch latch, TradeFund tradeFund, ApproverType approverType) {
		this.latch = latch;
		this.tradefund = tradeFund;
		this.approverType = approverType;
	}

	@Override
	public void run() {
		Approver<TradeFund> approver = ApproverFactory.getApprover(approverType);
		boolean isApproved = approver.approveFundRequest(tradefund);
		latch.countDown();
		if (isApproved) {
			System.out.println("Proceesed Request:" + approverType.name());
		} else {
			tradefund.setInterMediateFailure(true);
		}

	}

}
