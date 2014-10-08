package com.tma.gbst.syn.piexcercise.formular;

import java.util.Scanner;

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
	
}
