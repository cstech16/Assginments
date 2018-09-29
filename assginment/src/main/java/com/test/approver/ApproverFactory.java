package com.test.approver;

import java.util.EnumMap;
import java.util.Map;

import com.test.fund.TradeFund;

/**
 * Approver Factory
 * 
 * @author sushil
 *
 */
public class ApproverFactory {

	private static Map<ApproverType, Approver<? extends TradeFund>> map = new EnumMap<>(ApproverType.class);

	static {
		map.put(ApproverType.RESEACRH_ANALYST, new ResearchAnalystApprover());
		map.put(ApproverType.FUNDMANAGER, new FundManager());
		map.put(ApproverType.DIVISON_HEAD, new DivisonHead());
		map.put(ApproverType.OPERATIONS, new OperationApprover());
	}

	/**
	 * Will return right implementation based on Approver Type provided
	 * 
	 * @param approverType
	 * @return Approver Impl
	 */
	public static Approver getApprover(ApproverType approverType) {
		return map.get(approverType);
	}
}
