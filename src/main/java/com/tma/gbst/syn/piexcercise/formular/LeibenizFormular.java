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
	
	private volatile boolean isStop = false;
	
	private double result;
	
	private int count;

	/**
	 * Construct a Leibeniz Formula
	 */
	public LeibenizFormular(){};
	
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
	public void startCalculate() {
		
		for (int i = 0; i < count; i++){
			result +=  Math.pow(-1, i)/(2*i + 1);
			if (isStop) break;
		}
	}
	
	/**
	 * Stop to calculate pi number by this formular
	 */
	public void stopCalculate() {
		isStop = true;
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
