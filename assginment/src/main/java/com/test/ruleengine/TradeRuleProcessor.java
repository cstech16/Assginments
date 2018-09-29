package com.test.ruleengine;
/**
 * Rule Engineen Processor Interface
 * 
 * @author Sushil
 *
 * @param <T>
 */
public interface TradeRuleProcessor<T> {
	public void processAndGetTradeApproval(T obj);
}
