package com.test.approver;

import com.test.fund.TradeFund;

public class FundManager implements Approver<TradeFund>{

	@Override
	public boolean approveFundRequest(TradeFund tradeFund) {
		// TODO Auto-generated method stub
		return true;
	}

}
