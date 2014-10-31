package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formula.Result;

/**
 * The Leibniz Result format
 * 
 * @author tdainhan
 *
 */
public class LeibnizResult implements Result {
	
	long n;
	double pi = 0;
	
	/**
	 * Construct {@code LeibnizResult} without any parameters.
	 */
	public LeibnizResult(){};
	
	/**
	 * Construct {@code LeibnizResult} with given parameters.
	 * @param pi
	 * @param n
	 */
	public LeibnizResult(double pi, long n) {
		this.pi = pi;
		this.n = n;
	}

	/**
	 * Define the way to accumulate the result when another result was finished calculating.
	 */
	@Override
	public void add(Result r) {
		if (r instanceof LeibnizResult) {
			LeibnizResult lr = (LeibnizResult) r;
			pi += lr.pi;
			if (lr.getN() > n) {
				n = lr.getN();
			}
		}
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}
	
	/**
	 * Print out the final pi number was calculated with the current N number.
	 */
	@Override
	public String toString() {
		return "PI = " + pi + " with n = " + n;
	}
	
}
