package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

/**
 * This  class define the leibeniz formular
 * 
 * @author tdainhan
 * @version 1.0
 * @since 10/9/2014
 */
public class LeibenizFormular implements Formular {
	
	private static final String NAME = "Leibeniz Formular";
	
	private volatile boolean isStop;
	
	private double result;
	
	private long count;

	/**
	 * Construct a Leibeniz Formula
	 */
	public LeibenizFormular(){
		result = 0.0;
		isStop = false;
	};
	
	public LeibenizFormular(int count){
		this.count = count;
	}

	/**
	 * Set flag to determine the state to stop calculate
	 * 
	 * @param isStop  a flag to make the loop stop calculating the Pi number
	 */
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	/**
	 * 
	 * @param count the number of loop
	 */
	public void setCount(int count){
		this.count = count;
	}

	/**
	 * Start to calculate pi number follow it's formular
	 */
	public double startCalculate() {
		double denominator = 1;
	 
		for (int x = 0; x < count; x++) {

			if (x % 2 == 0) {
				result = result + (1 / denominator);
			} else {
				result = result - (1 / denominator);
			}
			denominator = denominator + 2;
			if (isStop) break;
		}
		
		return result;
	}
	
	/**
	 * get the number of loop from user 
	 */
	public void getInput(Scanner scanner){
		
		while(true){
			System.out.print("Enter the number of loop, the approximate of Pi will depend on this: ");
			String count = scanner.next();
			try {
				this.count = Long.parseLong(count);
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
		isStop = true;
		return getResult();
	}
	
	/**
	 * Get Pi number at current time, make sure you have start to calculate, otherwise
	 * it will return 0.0
	 */
	public double getResult(){
		return result*4;
	}

	/**
	 * Get formular name
	 */
	public String getFormularName(){
		return NAME;
	}

}
