package com.test.fund;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Model Entity
 * 
 * @author sushil
 *
 */
public class TradeFund {
	// to check if there is any failure in any intermediate approval step
	private AtomicBoolean intermediateFailure = new AtomicBoolean(false);

	public boolean isIntermediateFailure() {
		return intermediateFailure.get();
	}

	public void setInterMediateFailure(boolean failure) {
		intermediateFailure.compareAndSet(false, true);
	}
}
