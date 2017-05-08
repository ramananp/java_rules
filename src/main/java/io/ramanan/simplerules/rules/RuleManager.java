package io.ramanan.simplerules.rules;

import io.ramanan.simplerules.core.RuleEngine;
import io.ramanan.simplerules.rules.models.Person;

import java.util.Map;

/**
 * Created by ramanan on 5/7/17.
 */
public class RuleManager {

	public static void main(String[] args) {
		Person person = new Person("Ramanan", "Pathmaraj", 12);

		KidsRule kidsRule = new KidsRule();
		kidsRule.given(person);

		AdultsRule adultsRule = new AdultsRule();
		adultsRule.given(person);

		RuleEngine<Person, Integer> engine = new RuleEngine<>();
		Map<String, Integer> result = engine.fireRules(kidsRule, adultsRule);

		System.out.println("result = " + result);
	}

}
