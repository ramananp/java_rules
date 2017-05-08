package io.ramanan.simplerules.core;

/**
 * Created by ramanan on 5/7/17.
 */
public interface Rule<I, O> {

	String getName();

	void given(I i);

	boolean when();

	O then();

}
