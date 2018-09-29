package com.test.main;

import com.test.fund.TradeFund;
import com.test.ruleengine.RuleEngineFactory;
import com.test.ruleengine.RuleEngineType;
import com.test.ruleengine.TradeRuleProcessor;

/**
 * Trade Fund Request Receiver. Will Call rule Engine based on rule engine type
 * 
 * @author sushil
 *
 */
public class TradeFundRequestReceiver {
	public static void main(String[] args) {
		TradeFund tradeFund = new TradeFund();
		TradeRuleProcessor<TradeFund> tradeRuleProcessor = RuleEngineFactory
				.getRuleEngine(RuleEngineType.PARRALEL_RULE_ENGINE);
		tradeRuleProcessor.processAndGetTradeApproval(tradeFund);
	}

}
