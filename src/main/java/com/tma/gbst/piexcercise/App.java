package com.tma.gbst.piexcercise;

import java.io.IOException;

import com.tma.gbst.piexcercise.formular.Formula;
import com.tma.gbst.piexcercise.formular.leibniz.LeibnizFormula;

/**
 * <h1>Pi Calculation Program</h1> 
 * This program was created to calculate the approximate pi number.
 * 
 * Provide user calculate Pi number as much precise as they want the depend on
 * the time program run, when this program start to calculate, it also give an
 * option for user stop calculating at any time by pressing enter key to stop.
 * 
 * @author tdainhan
 * @version 1.0
 * @since 11/9/2014
 *
 */
public class App {

	
	/**
	 * This is entry point to calculate pi number, 
	 * 
	 * 
	 * @param args
	 * @return nothing
	 */
	public static void main(final String[] args) {
		
		if (!isParaValid(args)){
			System.out.println("Invalid input.");
			return;
		}

		final Formula formula = new LeibnizFormula();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				formula.setParameters(args);
				long startTime = System.currentTimeMillis();
				formula.calculate();
				
				System.out.println(formula.getResult());
				long stopTime = System.currentTimeMillis();
				System.out.println("Time taken: " + (stopTime - startTime) + "ms");
				System.exit(0);
			}
		});
		t1.start();
		
		System.out.println("PI is calculating.... If you want cancel it please press Enter.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		formula.cancel();
	}
	
	private static boolean isParaValid(String[] args){
		if (args == null)
			return false;
		String arg = args[0];
		try{
			long n = Long.parseLong(arg);
			if (n > Long.MAX_VALUE/2 - 1){
				return false;
			} else {
				return true;
			}
		} catch (Exception e){
			return false;
		}
	}

}
