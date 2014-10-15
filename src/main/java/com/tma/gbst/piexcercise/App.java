package com.tma.gbst.piexcercise;

import java.io.IOException;
import java.util.Scanner;

import com.tma.gbst.piexcercise.formular.Formula;
import com.tma.gbst.piexcercise.formular.leibniz.LeibnizFormula;

/**
 * <h1>Pi Calculation Program</h1> This program was created to calculate the
 * approximate pi number
 * 
 * Provide user calculate Pi number as much precise as they want the depend on
 * the time program run, when this program start to calculate, it also give an
 * option for user stop calculating at any time by pressing enter key to stop
 * 
 * @author tdainhan
 * @version 1.0
 * @since 11/9/2014
 *
 */
public class App {

	
	/**
	 * This is entry point to calculate pi number, calculate and decide whether
	 * or not continue calculating again
	 * 
	 * 
	 * @param args
	 * @return nothing
	 */
	public static void main(final String[] args) {

		
		final Formula formula = new LeibnizFormula();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				formula.setParameters(args);
				
				formula.calculate();
				
				System.out.print(formula.getResult());				
			}
		});
		t1.start();
		
		System.out.print("PI is calculating. If you want cancel it please press Enter");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		formula.cancel();
		System.out.println(formula.getResult());
	}

}
