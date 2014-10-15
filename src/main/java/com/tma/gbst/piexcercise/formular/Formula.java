package com.tma.gbst.piexcercise.formular;

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
	 * Starting to calculate pi number by this formular
	 */
	public void calculate();
	
	/**
	 * Stop calculate pi number
	 */
	public void cancel();
	
	/**
	 * Return the result of pi number after calculate
	 * 
	 * @return double the result of pi 
	 */
	public Result getResult();
	
}
