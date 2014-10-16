package com.tma.gbst.piexcercise.formular;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Responsible for receive the calculation order. Manage meta data, divide task
 * to {@code Worker} and get result from it.
 * 
 * Using {@code ScheduledThreadPoolExecutor} to manage thread.
 * 
 * @author tdainhan
 *
 */
public class Master {

	// using scheduled thread pool executor to make sure all task execute in
	// orderly.
	private ScheduledThreadPoolExecutor executors;

	// The result stores here.
	ArrayList<Future<Result>> futures;

	// The final value of Pi stored here.
	Result finalResult;

	// worker creator help to create a worker.
	WorkerCreator workerCreator;

	/**
	 * Construct a {@code Master} with given initial parameters. 
	 * 
	 * @param workerCreator  the {@code WorkerCretor} help to create {@code Worker}
	 * @param finalResult  the result instances responsible for get result after calculating 
	 * that was passed into {@code Master} class.
	 */
	public Master(WorkerCreator workerCreator, Result finalResult) {
		this.workerCreator = workerCreator;
		this.finalResult = finalResult;
	}

	/**
	 * Get the the result of pi value after calculating.
	 * 
	 * Iterating {@code ArrayList} futures, check each task whether done or not
	 * then get the result.
	 * 
	 * @return Result the result of calculating.
	 */
	public Result getResult() {
		for (Future<Result> fu : futures) {
			if (fu.isDone() && !fu.isCancelled()) {
				try {
					finalResult.add(fu.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
		return finalResult;
	}

	/**
	 * {@code Master} use this to divide task to all worker. Using
	 * {@link ScheduledThreadPoolExecutor} to manage all task that running and
	 * get result via a {@link List} of {@link Future}.
	 * 
	 * <p>
	 * Finding the number of available processor to set the number of
	 * thread that run simultaneously. Aiming to get the best performance.
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
			synchronized (this) {
				if (!executors.isShutdown()) {
					Future<Result> future = executors.submit(worker);
					futures.add(future);
				} else {
					break;
				}
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
	 * Attempt to shut down all task, after doing this, we wait for actively
	 * tasks execute, all task on waiting list will be canceled and no task can
	 * submit anymore.
	 */
	public void shutdown() {
		synchronized (this) {
			executors.shutdownNow();
		}
		try {
			executors.awaitTermination(120, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
