package io.ramanan.simplerules.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ramanan on 5/7/17.
 */
public class RuleEngine<I, O> {

	public Map<String, O> fireRules(List<Rule<I, O>> rules){
		return rules.stream().filter(Rule::when).collect(Collectors.toMap(Rule::getName,Rule::then));
	}

	@SafeVarargs
	public final Map<String, O> fireRules(Rule<I, O>... rules){
		return fireRules(Arrays.asList(rules));
	}

	public O fireRule(Rule<I, O> rule){
		if(rule.when()) return rule.then();
		return null;
	}

}
