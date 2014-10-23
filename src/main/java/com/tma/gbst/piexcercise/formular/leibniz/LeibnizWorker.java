package com.tma.gbst.piexcercise.formular.leibniz;

import java.util.concurrent.Callable;

import com.tma.gbst.piexcercise.formular.Result;
import com.tma.gbst.piexcercise.formular.Worker;

/**
 * The {@code LeibnizWorker} are responsible for calculating for Leibniz formula. 
 * It was managed and received the order by Master
 * 
 * @author tdainhan
 *
 */
public class LeibnizWorker implements Worker   {
	
	private long begin;
	private long end;
	
	/**
	 * Construct {@code LeibnizWorker} without any parameters.
	 */
	public LeibnizWorker(){};
	
	/**
	 * Construct {@code LeibnizWorker} with given parameters.
	 * @param begin  the begin number of series that this {@code LeibnizWorker} instance do.
	 * @param end  the end number of series that this {@code LeibnizWorker} instance do.
	 */
	public LeibnizWorker(long begin, long end){
		this.begin = begin;
		this.end = end;
	}

	/**
	 * Set the begin number of series that this {@code LeibnizWorker} instance do. 
	 */
	public void setBegin(long begin) {
		this.begin = begin;
	}

	/**
	 * Set the end number of series that this {@code LeibnizWorker} instance do.
	 */
	public void setEnd(long end) {
		this.end = end;
	}
	
	/**
	 * Get the end number of series that this {@code LeibnizWorker} instance do.
	 */
	public long getEnd() {
		return end;
	}
	
	/**
	 * Main function of this class. This method will calculate base on the begin and end number
	 * following this specific formula. 
	 */
	private double work(){
		double result = 0.0;
		
		long denominator = 1 + 2*begin;
		 
		for (long i = begin; i <= end; i++) {

			if (i % 2 == 0) {
				result = result + (1.0 / denominator);
			} else {
				result = result - (1.0 / denominator);
			}
			denominator = denominator + 2;
		}
		
		return result;
	};

	/**
	 * Implement the method of {@link Callable}. After this {@ LeibnizWorker} finish it's work,
	 * the result will be return to the {@link Future} the manage this task.
	 */
	public Result call() throws Exception {
		double pi = work() *  4;
		Result result = new LeibnizResult(pi, getEnd());
		return result;
	}
	
}
