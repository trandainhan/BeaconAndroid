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
	
	/**
	 * Set the begin number of this {@code Worker} do.
	 * 
	 * @param begin  the begin number of this {@code Worker} do.
	 */
	public void setBegin(long begin);
	
	/**
	 * Set the end number of this {@code Worker} do.
	 * @param end  the end number of this {@code Worker} do.
	 */
	public void setEnd(long end);
	
	/**
	 * Get the end number of series that this {@code Worker} do.
	 * @return long  the end number of series that this {@code Worker} do.
	 */
	public long getEnd();
	
	/**
	 * {@code Worker} use this method to calculate the formula.
	 * 
	 * @param begin  the begin number of this {@code Worker} do.
	 * @param end  the end number of series that this {@code Worker} do.
	 * @return double  the result after working.
	 */
	public double work(long begin, long end);
	
}
