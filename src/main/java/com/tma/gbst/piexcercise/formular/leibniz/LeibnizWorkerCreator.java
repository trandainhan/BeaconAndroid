package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formular.WorkerCreator;

public class LeibnizWorkerCreator implements WorkerCreator {
	
	
	private int slice = 10000;
	private long n; 
	private long lastIndex = -1;
	
	public LeibnizWorkerCreator(){};
	
	public LeibnizWorkerCreator(long n){
		this.n = n;
	}
	
	public void setN(long n){
		this.n = n;
	}
	
	public LeibnizWorker createNextWorker() {
		LeibnizWorker leibnizWorker;
		
		if (lastIndex < n){
			leibnizWorker = new LeibnizWorker(lastIndex + 1, lastIndex + 10000);
		} else {
			leibnizWorker = new LeibnizWorker(lastIndex + 1, n);
		}
		lastIndex = lastIndex + 10000;
		
		return leibnizWorker;
	}
}
