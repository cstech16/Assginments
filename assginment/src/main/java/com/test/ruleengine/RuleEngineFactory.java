package com.test.ruleengine;
/**
 * Rule Engine Factory
 * @author Sushil
 *
 */
public class RuleEngineFactory {

	public static TradeRuleProcessor getRuleEngine(RuleEngineType ruleEngine) {
		if (RuleEngineType.PARRALEL_RULE_ENGINE.equals(ruleEngine)) {
			return ParallerTradeRuleProcessor.getInstance();
		}
		return null;
	}
}
