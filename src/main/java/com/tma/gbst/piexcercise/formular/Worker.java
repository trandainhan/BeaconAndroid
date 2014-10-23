package com.tma.gbst.piexcercise.formular;

import java.util.concurrent.Callable;

/**
 * {@code Worker} responsible for calculate the formula when it was asked. {@code Worker} extend {@link Callable<V>}
 * 
 *  <p> This interface will be implement by a specific {@code Worker} of formula 
 *  to determine what exactly formula do.
 * @author tdainhan
 *
 */
public interface Worker extends Callable<Result> {
	
}
