package com.tma.gbst.syn.piexcercise.paralellprocessing;

public interface Worker extends Runnable {
	
	interface CallBack{
		void call(int id, double result);
	}
	
	public void setIdentifier(int id);
	
	public void setCallback(CallBack callBack);
	
	public void setBegin(long begin);
	
	public void setEnd(long end);
	
	public double work(long begin, long end);
	
}
