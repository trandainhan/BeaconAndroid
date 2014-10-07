package com.tma.gbst.syn.piexcercise.app;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.tma.gbst.syn.piexcercise.calculation.PiCalculation;
import com.tma.gbst.syn.piexcercise.formular.Formular;
import com.tma.gbst.syn.piexcercise.formular.LeibenizFormular;

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
	 * This is main method to calculate pi number
	 * 
	 * <tt>PiCalculation</tt> was used to calculate, by setting it's formular.
	 * Program start calculating Pi in another thread. By pressing enter key the
	 * program will stop and getting the result
	 * 
	 * @param args
	 * @return nothing
	 */
	public static void main(String[] args) {

		System.out
				.println("This program is used to calculate approximate pi number.");

		PiCalculation piCalculation = new PiCalculation();

		/**
		 * Define amd set formular to use
		 */
		Formular formular = new LeibenizFormular();
		System.out.println("Using " + formular.getFormularName()
				+ " to calculate the approximate Pi number");

		piCalculation.setFormular(formular);

		System.out.println("The pi number was calculed by: "
				+ formular.getFormularName());

		/**
		 * Start calculate the pi number
		 */
		Thread t = piCalculation.startCalculate();
		
		System.out.print("Press enter to stop calculate if you don't want to wait more, the approximation of pi will depend on this ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();

		Double result = 0.0;
		/**
		 * Stop calculate number to get the result if user press any key...
		 */
		try {
			result = piCalculation.stopCalculate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.printf("The approximation of Pi: %.20f", result);
	}

}
