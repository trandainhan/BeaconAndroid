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
//	private static final String MY_WORKER = "LeibenizWorker";
	
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
	 * get the number of loop from user 
	 */
	public void getInput(Scanner scanner){		
		while(true){
			System.out.print("Enter the number of loop, the approximate of Pi will depend on this: ");
			String count = scanner.next();
			try {
				this.master.setCount(Long.parseLong(count));
				break;
			} catch (Exception e) {
				System.out.println("The value is invalid, try again.");
			}
		}
		while(true){
			System.out.print("Enter the number of Thread you want to run stimunously: ");
			String nThread = scanner.next();
			try {
				this.master.setnThreads(Integer.parseInt(nThread)); 
				break;
			} catch (Exception e) {
				System.out.println("The value is invalid, try again.");
			}
		}
		while(true){
			System.out.print("Enter the number of Slice: ");
			String slice = scanner.next();
			try {
				this.master.setSlice(Integer.parseInt(slice)); 
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
		return master.getResult();
	}

	/**
	 * Get formular name
	 */
	public String getFormularName(){
		return NAME;
	}

}
