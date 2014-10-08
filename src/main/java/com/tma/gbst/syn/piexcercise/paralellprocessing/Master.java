package com.tma.gbst.syn.piexcercise.paralellprocessing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Worker.CallBack;


public class Master implements CallBack {
	
	ExecutorService executors;
	String kindOfWorker;
	
	long count;
	int slice;
	int nThreads;
	
	double result;
	
	public Master(){}
	
	public Master(int count, int slice, int nThreads, String kindOfWorker){
		this.count = count;
		this.slice = slice;
		this.nThreads = nThreads;
		this.kindOfWorker = kindOfWorker;
	}
	
	public Master(String kindOfWorker){
		this.kindOfWorker = kindOfWorker;
	}

	public void setCount(long count) {
		this.count = count + 1;
	}

	public void setSlice(int slice) {
		this.slice = slice;
	}

	public void setnThreads(int nThreads) {
		this.nThreads = nThreads;                                                                                                                                                                   
	}
	
	public double getResult(){
		return result*4;
	}

	public void processing(){
		// devide into many slice then inject to worker
		
		executors = Executors.newFixedThreadPool(nThreads);
		
		long segment = count/slice;
		long begin;
		long end;
		for (long i = 0; i < segment; i++){
			begin = i*slice + 1;
			end = (i + 1)*slice;
			try {
				submitWorker(executors, begin, end);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		executors.shutdown();
	}

	private void submitWorker(ExecutorService executors, long begin, long end)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Worker worker;
		worker = (Worker) Class.forName(kindOfWorker).newInstance();
		worker.setBegin(begin);
		worker.setEnd(end);
		worker.setCallback(this);
		executors.submit(worker);
	}
	
	public void shutdown(){
		executors.shutdownNow();
	}

	public void call(double value) {
		synchronized (this) {
			result += value;
		}
	}
	
}
