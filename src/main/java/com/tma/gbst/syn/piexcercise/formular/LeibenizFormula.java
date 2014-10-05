package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

/**
 * This  class define the leibeniz formula
 * 
 * @author tdainhan
 * @version 1.0
 * @since 10/9/2014
 */
public class LeibenizFormula implements Formular {
	
	public static final String NAME = "Leibeniz Formular";
	
	private volatile boolean isStop = false;
	
	private double result;

	/**
	 * Construct a Leibeniz Formula
	 */
	public LeibenizFormula(){};

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}


	/**
	 * this method is used to calculate pi number follow it's formula
	 * return double This return the approximate pi number
	 */
	public void startCalculate() {
		
        int i = 0;
		while (!isStop){
			result +=  Math.pow(-1, i)/(2*i + 1);
			i++;
		}
	}
	
	public void stopCaculate() {
		isStop = true;
	}
	
	public double getResult(){
		return result*4;
	}

	public String getFormulaName(){
		return NAME;
	}

}
