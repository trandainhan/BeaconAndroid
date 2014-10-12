package com.tma.gbst.syn.piexcercise.paralellprocessing;

import java.util.concurrent.Callable;

public interface Worker extends Callable<Double> {
	
	interface CallBack{
		void call(int id, double result);
	}
	
	public void setIdentifier(int id);
	
	public void setCallback(CallBack callBack);
	
	public void setBegin(long begin);
	
	public void setEnd(long end);
	
	public double work(long begin, long end);
	
}
