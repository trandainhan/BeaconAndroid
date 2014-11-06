package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formula.WorkerCreator;

/**
 * {@code LeibnizWorkerCreator} help to create a specific {@link LeibnizWorker }.
 * @author tdainhan
 *
 */
public class LeibnizWorkerCreator implements WorkerCreator {
	
	// The number that each thread calculate.
	private long slice = 20000;
	
	// The number of series. 
	private long n;
	
	// The last number was calculated.
	private long lastIndex = -1;
	
	/**
	 * Construct {@code LeibnizWorkerCreator} with the N number of leibniz formula.
	 * 
	 * @param n  the N number of leibniz formula.
	 */
	public LeibnizWorkerCreator(long n){
		this.n = n;
		if (slice > n){
			slice = (int) n;
		}
		if (slice == 0) slice = 1;
	}
	
	/**
	 * Set the N number of leibniz formula.
	 * 
	 * @param n  the N number of leibniz formula.
	 */
	public void setN(long n){
		this.n = n;
	}
	
	/**
	 * Set the slice the number that each thread calculate.
	 * 
	 * @param slice  the number that each thread calculate.
	 */
	public void setSlice(int slice){
		this.slice = slice;
	}
	
	/**
	 * Create {@link LeibnizWorker}.
	 */
	public LeibnizWorker createNextWorker() {
		LeibnizWorker leibnizWorker = null;
		
		if (lastIndex >= n)
			return leibnizWorker;
		
		if (lastIndex + slice < n){
			leibnizWorker = new LeibnizWorker(lastIndex + 1, lastIndex + slice);
		} else {
			leibnizWorker = new LeibnizWorker(lastIndex + 1, n);
		}
		lastIndex = lastIndex + slice;
		
		return leibnizWorker;
	}
}
