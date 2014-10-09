package com.tma.gbst.syn.piexcercise.paralellprocessing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Worker.CallBack;


public class Master implements CallBack {
	
	ExecutorService executors;
	String kindOfWorker;
	
	long count;
	int slice;
	int nThreads;
	
	//array to result receive from worker;
	double results[];
	
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
		double t = 0.0;
		for (int i = 0; i < results.length; i++){
			t += results[i];
		}
		return t;
	}

	public void processing(){
		
		results = new double[nThreads];
		
		// devide into many slice then inject to worker
		executors = Executors.newFixedThreadPool(nThreads);
		

		new Thread(new Runnable() {
			
			public void run() {
				long segment = count/slice;
				
				
				long begin;
				long end;
				int j = 0;
				for (int i = 0; i < segment; i++){
					begin = i*slice;
					end = (i + 1)*slice - 1;
					try {
						submitWorker(j, executors, begin, end);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					j++;
					if (j >= nThreads - 1) j = 0;
				}
				
				if (count % slice != 0){
					begin = slice * (count/slice);
					end = count - 1;
					try {
						submitWorker(nThreads - 1, executors, begin, end);
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
		}).start();
		
	}

	private void submitWorker(int id, ExecutorService executors, long begin, long end)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Worker worker;
		worker = (Worker) Class.forName(kindOfWorker).newInstance();
		worker.setIdentifier(id);
		worker.setBegin(begin);
		worker.setEnd(end);
		worker.setCallback(this);
		executors.submit(worker);
	}
	
	public void shutdown(){
		executors.shutdownNow();
	}
	
	public boolean isTerminated(){
		return executors.isTerminated();
	}

	public void call(int id, double value){
		results[id] += value;
	}
	
}
