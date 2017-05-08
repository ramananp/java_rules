package io.ramanan.easyrules.rules;

import java.util.ArrayList;

import org.easyrules.api.Rule;
import org.easyrules.spring.RulesEngineFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

	@Bean
	public RulesEngineFactoryBean factory(Rule eligibilityRule){
		RulesEngineFactoryBean factoryBean = new RulesEngineFactoryBean();
		
		factoryBean.setRules(new ArrayList<Object>(){
			private static final long serialVersionUID = 1L;
			{
				add(eligibilityRule);
			}
		});
		
		return factoryBean;
	}
	
}
