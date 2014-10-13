package com.tma.gbst.syn.piexcercise.paralellprocessing;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Responsible for receive the calculation order. Manage metadata, divide task to <tt>Worker</tt>
 * and get result from it
 * @author nhantran
 *
 */
public class Master{
	
	public final String CLASS_NAME = this.getClass().getSimpleName();
	
	// all parameter for a formula running
	long count;
	int slice;
	int nThreads;
	
	
	private volatile ScheduledThreadPoolExecutor executors;
	private String kindOfWorker;
	
	// The result stores here
	LinkedList<Future<Double>> futures;
	
	/**
	 * Contruct <tt>Master</tt> with no parameter 
	 */
	public Master(){}
	
	/**
	 * Construct <tt>Master</tt> with the kind of worker that run the task
	 * 
	 * @param kindOfWorker  the kind of worker that run the task
	 */
	public Master(String kindOfWorker){
		this.kindOfWorker = kindOfWorker;
	}
	
	/**
	 * Construct <tt>Master</tt> with full parameter
	 * 
	 * @param count  the number of series
	 * @param slice  the number splitting the series
	 * @param nThreads  the number thread that run simultaneously
	 * @param kindOfWorker  the kind of <tt>Worker</tt< responsible for this task
	 */
	public Master(int count, int slice, int nThreads, String kindOfWorker){
		this.count = count;
		this.slice = slice;
		this.nThreads = nThreads;
		this.kindOfWorker = kindOfWorker;
	}

	/**
	 * 
	 * @param count
	 */
	public void setCount(long count) {
		this.count = count + 1;
	}

	/**
	 * set slice, the number that splitting series into many part
	 *  
	 * @param slice  this splitting series in to many part
	 */
	public void setSlice(int slice) {
		this.slice = slice;
	}

	/**
	 * set the number of thread that run simultaneously
	 * @param nThreads  the number of thread that run simultaneously
	 */
	public void setnThreads(int nThreads) {
		this.nThreads = nThreads;
	}
	
	/**
	 * get the the result of pi value after calculating.
	 * 
	 * @return double the result of pi value
	 */
	public double getResult(){
		double t = 0.0;	
		for (Future<Double> fu : futures){
			if (fu.isDone()){
				if (!fu.isCancelled()){
					try{
						t += fu.get();
					} catch (Exception e){
						System.out.println(e.getCause());
					}
				}
			} else {
				fu.cancel(true);
			}
		}
		return t;
		
	}

	/**
	 * <tt>Master</tt> use this to manage <tt>Worker</tt>, divide task to all worker
	 * Using schedule thread pool to manage all task that running and get result via <tt>Future</tt>  in oderly
	 * 
	 */
	public void processing(){
		
		futures = new LinkedList<Future<Double>>();
		
		// set maximum pool size equal to core pool size to make it become  fixed-size thread pool
		executors = new ScheduledThreadPoolExecutor(nThreads);
		executors.setMaximumPoolSize(nThreads);

		new Thread(new Runnable() {
			
			public void run() {
				
				long segment = count/slice;
				long begin;
				long end;
				
				for (long i = 0; i < segment; i++){
					begin = i*slice;
					end = (i + 1)*slice - 1;
					if(!executors.isShutdown()){
						try {
							Future<Double> future = submitWorker(executors, begin, end);
							futures.add(future);
						} catch (Exception e) {}						
					}
				}
				
				if (count % slice != 0){
					begin = slice * (count/slice);
					end = count - 1;
					if(!executors.isShutdown()){
						try {
							submitWorker(executors, begin, end);
						} catch (Exception e) {}						
					}
				}
				executors.shutdown();
			}
		}).start();
		
	}

	/**
	 * Submit task to executor
	 * 
	 * @param executors
	 * @param begin
	 * @param end
	 * @return
	 * @throws Exception
	 */
	private synchronized Future<Double> submitWorker(ExecutorService executors, long begin, long end)
			throws Exception {
		Worker worker;
		worker = (Worker) Class.forName(kindOfWorker).newInstance();
		worker.setBegin(begin);
		worker.setEnd(end);
		return executors.submit(worker);
	}
	
	/**
	 * shut down all task, after doing this, no task will be submit anymore
	 */
	public void shutdown(){
		executors.shutdown();
	}
	
	/**
	 * 
	 * @return <tt>true</tt>  if all task have completed following shutdown
	 */
	public boolean isTerminated(){
		return executors.isTerminated();
	}
	
}
