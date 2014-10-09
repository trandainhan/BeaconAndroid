package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

import com.tma.gbst.syn.piexcercise.paralellprocessing.Master;

public interface Formular {
	
	/**
	 * get the name of formular
	 * 
	 * @return string  the name of formular
	 */
	public String getFormularName();
	
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
	public double stopCalculate();
	
	/**
	 * Return the result of pi number after calculate
	 * 
	 * @return double  the result of pi 
	 */
	public double getResult();
	
	/**
	 * Return the manager thread, that manage all thread 
	 * @return  Master  the manage thread 
	 */
	public Master getMasterThread();
	
}
