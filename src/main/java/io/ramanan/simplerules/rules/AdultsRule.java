package io.ramanan.simplerules.rules;

import io.ramanan.simplerules.core.Rule;
import io.ramanan.simplerules.rules.models.Person;

/**
 * Created by ramanan on 5/7/17.
 */
public class AdultsRule implements Rule<Person, Integer> {

	private Person person;

	@Override
	public String getName() {
		return "adultsRule";
	}

	@Override
	public void given(Person person) {
		this.person = person;
	}

	@Override
	public boolean when() {
		return this.person.getAge() > 12;
	}

	@Override
	public Integer then() {
		return 500;
	}
}
