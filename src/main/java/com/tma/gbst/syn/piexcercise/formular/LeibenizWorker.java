package com.tma.gbst.syn.piexcercise.formular;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Worker;

public class LeibenizWorker implements Worker   {
	
	public final String CLASS_NAME = this.getClass().getSimpleName();
	
	private long begin;
	private long end;
	
	
	public LeibenizWorker(){};
	
	public LeibenizWorker(long begin, long end){
		this.begin = begin;
		this.end = end;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	
	public double work(long begin, long end){
		double result = 0.0;
		
		long denominator = 1 + 2*begin;
		 
		for (long i = begin; i <= end; i++) {

			if (i % 2 == 0) {
				result = result + (1.0 / denominator);
			} else {
				result = result - (1.0 / denominator);
			}
			denominator = denominator + 2;
			
			if (Thread.currentThread().isInterrupted()) break;
		}
		
		return result;
	};

	public Double call() throws Exception {
		return work(begin, end);
		
	}
}
