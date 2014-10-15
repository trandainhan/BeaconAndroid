package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formular.Result;
import com.tma.gbst.piexcercise.formular.Worker;


public class LeibnizWorker implements Worker   {
	
	private long begin;
	private long end;
	
	public LeibnizWorker(){};
	
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
	
	@Override
	public long getEnd() {
		return end;
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

	public Result call() throws Exception {
		double pi = work(begin, end) *  4;
		Result result = new LeibnizResult(pi, getEnd());
		return result;
	}
	
}
