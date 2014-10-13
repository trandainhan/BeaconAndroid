package com.tma.gbst.syn.piexcercise.paralellprocessing;

import java.util.concurrent.Callable;

public interface Worker extends Callable<Double> {
	
	public void setBegin(long begin);
	
	public void setEnd(long end);
	
	public double work(long begin, long end);
	
}
