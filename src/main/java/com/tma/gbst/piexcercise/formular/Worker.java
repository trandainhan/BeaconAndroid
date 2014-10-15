package com.tma.gbst.piexcercise.formular;

import java.util.concurrent.Callable;

public interface Worker extends Callable<Result> {
	
	public void setBegin(long begin);
	
	public void setEnd(long end);
	
	public long getEnd();
	
	public double work(long begin, long end);
	
}
