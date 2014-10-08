package com.tma.gbst.syn.piexcercise.formular;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Worker;

public class LeibenizWorker implements Worker   {
	
	private int id;
	
	private CallBack callback;
	
	private long begin;
	private long end;
	
	
	public LeibenizWorker(){};
	
	public LeibenizWorker(long begin, long end){
		this.begin = begin;
		this.end = end;
	}
	
	public void setIdentifier(int id){
		this.id = id;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	
	public void setCallback(CallBack callback) {
		this.callback = callback;
	}
	
	public double work(long begin, long end){
		double result = 0.0;
		
		double denominator = 1 + 2*begin;
		 
		for (long i = begin; i <= end; i++) {

			if (i % 2 == 0) {
				result = result + (1 / denominator);
			} else {
				result = result - (1 / denominator);
			}
			denominator = denominator + 2;
		}
		
		return result;
	};


	public void run() {
		double result = work(begin, end);
		if (Thread.currentThread().isInterrupted()){
			callback.call(id, result);
		} else {
			callback.call(id, result);
		}
	}
}
