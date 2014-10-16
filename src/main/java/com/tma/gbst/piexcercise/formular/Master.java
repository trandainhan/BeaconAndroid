package com.tma.gbst.piexcercise.formular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Responsible for receive the calculation order. Manage meta data, divide task
 * to <tt>Worker</tt> and get result from it
 * 
 * @author nhantran
 *
 */
public class Master {

	public final String CLASS_NAME = this.getClass().getSimpleName();


	// using scheduled thread pool executor to make sure all task execute in
	// orderly
	private volatile ScheduledThreadPoolExecutor executors;

	// The result stores here
	ArrayList<Future<Result>> futures;

	// The final value of Pi stored here
	Result finalResult;

	WorkerCreator workerCreator;

	/**
	 * Construct <tt>Master</tt> with no parameter
	 */
	public Master() {
	}

	/**
	 * Construct <tt>Master</tt> with the kind of worker that run the task
	 * 
	 * @param kindOfWorker
	 *            the kind of worker that run the task
	 */
	public Master(WorkerCreator workerCreator, Result finalResult) {
		this.workerCreator = workerCreator;
		this.finalResult = finalResult;
	}

	/**
	 * get the the result of pi value after calculating.
	 * 
	 * @return double the result of pi value
	 */
	public Result getResult() {
		for (Future<Result> fu : futures) {
			if (!fu.isCancelled() && fu.isDone()){
				try {
					finalResult.add(fu.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}	
			}
			
		}
		return finalResult;
	}

	/**
	 * <tt>Master</tt> use this to manage <tt>Worker</tt>, divide task to all
	 * worker Using schedule thread pool to manage all task that running and get
	 * result via <tt>Future</tt> in orderly
	 * 
	 */
	public void process() {

		futures = new ArrayList<Future<Result>>();

		// set maximum pool size equal to core pool size to make it become
		// fixed-size thread pool
		int cores = Runtime.getRuntime().availableProcessors();
		executors = new ScheduledThreadPoolExecutor(cores);
		executors.setMaximumPoolSize(cores);

		Worker worker;
		while ((worker = workerCreator.createNextWorker()) != null) {
			if (!executors.isShutdown()){
				Future<Result> future = executors.submit(worker);
				futures.add(future);				
			} else {
				break;
			}
		}
		executors.shutdown();
		try {
			executors.awaitTermination(120, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * shut down all task, after doing this, no task will be submit anymore
	 */
	public void shutdown() {
		executors.shutdownNow();
		try {
			executors.awaitTermination(120, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
