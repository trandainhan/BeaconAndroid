package com.tma.gbst.syn.piexcercise.formular.leibniz;

import com.tma.gbst.syn.piexcercise.formular.Worker;


public class LeibnizWorker implements Worker   {
	
	public final String CLASS_NAME = this.getClass().getSimpleName();
	
	private long begin;
	private long end;
	
	
	private LeibnizWorker(){};
	
	public LeibnizWorker(long begin, long end){
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
		}
		
		return result;
	};

	public Double call() throws Exception {
		return work(begin, end);
		
	}

	@Override
	public Worker createWorker() {
		return LeibnizWorker();
	}
}
