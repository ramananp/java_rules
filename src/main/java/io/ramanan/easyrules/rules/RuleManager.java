package io.ramanan.easyrules.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.spring.RulesEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleManager {
	
	private RulesEngineFactoryBean factoryBean;
	
	@Autowired
	public RuleManager(RulesEngineFactoryBean factoryBean){
		this.factoryBean = factoryBean;
	}
	
	public void executeRule(){
		RulesEngine engine = (RulesEngine)factoryBean;
	}
	
}
