package com.test.approver;

import com.test.fund.TradeFund;

/**
 * Approver Instance
 * @author sushil
 *
 * @param <T>
 */
public interface Approver<T extends TradeFund> {
	public boolean approveFundRequest(T tradeFund);
}
