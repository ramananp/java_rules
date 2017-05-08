package io.ramanan.easyrules.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.core.BasicRule;
import org.easyrules.spring.SpringRule;

@SpringRule
public class EligibilityRule extends BasicRule{


	@Condition
	public boolean when(){
		return true;
	}
	
	@Action
	public void then(){
		System.out.println("Hello, World!!");
	}

}
