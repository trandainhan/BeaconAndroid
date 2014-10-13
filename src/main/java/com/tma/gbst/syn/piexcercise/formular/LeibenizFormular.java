package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Master;

/**
 * This  class define the leibeniz formular
 * 
 * @author tdainhan
 * @version 1.0
 * @since 10/9/2014
 */
public class LeibenizFormular  implements Formular {
	
	private static final String NAME = "Leibeniz Formular";
	
	private Master master;
	
	/**
	 * Construct a Leibeniz Formula
	 */
	public LeibenizFormular(){
		master = new Master(LeibenizWorker.class.getName());
	};

	/**
	 * Start to calculate pi number follow it's formular
	 */
	public void startCalculate() {
		master.processing();
	}
	
	/**
	 * get all parameter to calculate from user 
	 */
	public void getInput(Scanner scanner){
		long count;
		int nThread;
		int slice;
		while(true){
			System.out.print("Enter the number of loop, the approximate of Pi will depend on this: ");
			
			try {
				count = Long.parseLong(scanner.next());
				if (count < 0) throw new Exception();
				this.master.setCount(count);
				break;
			} catch (Exception e) {
				System.out.println("The value is invalid, try again.");
			}
		}
		while(true){
			System.out.print("Enter the number of Thread you want to run stimunously, should be larger than 1: ");
			try {
				nThread = Integer.parseInt(scanner.next());
				if (nThread < 1) throw new Exception();
				this.master.setnThreads((nThread)); 
				break;
			} catch (Exception e) {
				System.out.println("The value is invalid, try again.");
			}
		}
		while(true){
			System.out.print("Enter the number of Slice: ");
			try {
				slice = Integer.parseInt(scanner.next());
				if (slice <= 0) throw new Exception();
				if (slice < nThread){
					slice = nThread;
				}
				if (count == 0){
					slice = 1;
				}
				this.master.setSlice(slice);
				break;
			} catch (Exception e) {
				System.out.println("The value is invalid, try again.");
			}
		}
	}
	
	/**
	 * Stop to calculate pi number by this formular
	 */
	public double stopCalculate() {
		master.shutdown();
		return getResult();
	}
	
	/**
	 * Get Pi number at current time, make sure you have start to calculate, otherwise
	 * it will return 0.0
	 */
	public double getResult(){
		return master.getResult()* 4;
	}

	/**
	 * Get formular name
	 */
	public String getFormularName(){
		return NAME;
	}

	/**
	 * get the <tt>Master</tt> thread that manage to run the calculation
	 * @return <tt>Master</tt>  a master thread that manage to run the calculation
	 */
	public Master getMasterThread() {
		return master;
	}
	
	

}
