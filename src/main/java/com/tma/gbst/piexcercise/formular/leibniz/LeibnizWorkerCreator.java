package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formular.WorkerCreator;

public class LeibnizWorkerCreator implements WorkerCreator {
	
	
	private int slice = 10000;
	private long n; 
	private long lastIndex = -1;
	
	public LeibnizWorkerCreator(){};
	
	public LeibnizWorkerCreator(long n){
		this.n = n;
		if (slice > n){
			slice = (int) n;
		}
	}
	
	public void setN(long n){
		this.n = n;
	}
	
	public LeibnizWorker createNextWorker() {
		LeibnizWorker leibnizWorker = null;
		
		if (lastIndex >= n)
			return leibnizWorker;
		
		if (lastIndex + slice < n){
			leibnizWorker = new LeibnizWorker(lastIndex + 1, lastIndex + slice);
		} else {
			leibnizWorker = new LeibnizWorker(lastIndex + 1, n);
		}
		lastIndex = lastIndex + slice;
		
		return leibnizWorker;
	}
}
