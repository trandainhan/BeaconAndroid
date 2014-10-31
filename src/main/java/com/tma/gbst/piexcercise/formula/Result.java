package com.tma.gbst.piexcercise.formula;

/**
 * This interface should implemented by a specific result class of a formula.
 * The class must implement a method call {@code add}, this method help you
 * change the result after calculate.
 * 
 * @author tdainhan
 *
 */
public interface Result {
	
	/**
	 * Add the new {@code Result} the the exist {@code Result}. This aim to change result or anything you want.
	 * 
	 * @param r  the result was added.
	 */
	public void add(Result r);
	
}
