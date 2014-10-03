package org.tma.gbst.syn.java_entry_code;

import java.util.Scanner;

/**
 * This  class define the leibeniz formula
 * 
 * @author tdainhan
 * @version 1.0
 * @since 10/9/2014
 */
public class LeibenizFormula implements Formula {
	
	public static final String NAME = "Leibeniz Formula";
	private int count;

	/**
	 * Construct a Leibeniz Formula
	 */
	public LeibenizFormula(){};
	
	/**
	 * Construct a Leibeniz Formula with specified limit number to iterate
	 * 
	 * @param count
	 */
	public LeibenizFormula(int count){
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * this method is used to calculate pi number follow it's formula
	 * return double This return the approximate pi number
	 */
	public double calculate() {
		
		if (count == 0){
			System.out.print("Enter the number of iteration, the approximation of pi will depend on this: ");
	        Scanner scanner = new Scanner(System.in);
	        count = scanner.nextInt();
	        scanner.close();
		}
        
		double result = 0;
        
        for (int i = 0; i <= count; i++){
        	result +=  Math.pow(-1, i)/(2*i + 1);
        }
        
        return result*4;
	}
	
	public String getFormulaName(){
		return NAME;
	}

}
