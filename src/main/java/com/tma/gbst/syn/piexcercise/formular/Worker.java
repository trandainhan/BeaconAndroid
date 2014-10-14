package com.tma.gbst.syn.piexcercise.formular;

import java.util.concurrent.Callable;

public interface Worker extends Callable<Double> {
	
	public void setBegin(long begin);
	
	public void setEnd(long end);
	
	public void getEnd();
	
	public double work(long begin, long end);
	
	public Worker createWorker();
	
}
