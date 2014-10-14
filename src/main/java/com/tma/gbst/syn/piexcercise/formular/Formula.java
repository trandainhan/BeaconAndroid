package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

public interface Formula {
	
	/**
	 * get the name of formula
	 * 
	 * @return string  the name of formula
	 */
	public String getFormularName();

	public void setParameters(String[] parameters);
	
	/**
	 * get the point to help formular calculate
	 */
	public void getInput(Scanner scanner);
	
	/**
	 * Starting to calculate pi number by this formular
	 */
	public void startCalculate();
	
	/**
	 * Stop calculate pi number
	 */
	public void stopCalculate();
	
	/**
	 * Return the result of pi number after calculate
	 * 
	 * @return double the result of pi 
	 */
	public double getResult();
	
//	/**
//	 * Return the manager thread, that manage all thread 
//	 * @return  Master  the manage thread 
//	 */
//	public Master getMasterThread();
	
}
