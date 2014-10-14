package com.tma.gbst.syn.piexcercise;

import java.util.Scanner;

import com.tma.gbst.syn.piexcercise.calculation.PiCalculation;
import com.tma.gbst.syn.piexcercise.formular.Formula;
import com.tma.gbst.syn.piexcercise.formular.leibniz.LeibnizFormula;

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
	public static void main(String[] args) {

//		while (true) {
//			// @SuppressWarnings("resource")
//			Scanner inputTool = new Scanner(System.in);
//			start(inputTool);
//			inputTool = new Scanner(System.in);
//			System.out
//					.println("Press C key to continue calculate other key will stop program");
//			String line = inputTool.nextLine();
//			if (!line.equalsIgnoreCase("c")) {
//				inputTool.close();
//				System.out.println("------Stop-----");
//				break;
//			}
//		}
		Thread t = new Thread() { 
			
		Formula formula = new LeibnizFormula();
		formula.setParameters(args);
		
		formula.startCalculate();
		
		System.out.print(formula.getResult());
		}
		
		System.out.print("PI is calculating. If you want cancel it please press Enter");
		System.in.read();
		if () {
			formula.stopCalculate();
		}
	}

	/**
	 * 
	 * <tt>PiCalculation</tt> was used to calculate, by setting it's formular.
	 * Program start calculating Pi in another thread. By pressing enter key the
	 * program will stop and getting the result
	 * 
	 * @param scanner
	 *            get input from user through scanner
	 */
	private static void start(Scanner scanner) {
		System.out
				.println("This program is used to calculate approximate pi number.");

		PiCalculation piCalculation = new PiCalculation();

		/*
		 * Define and set formula to use
		 */
		Formula formular = new LeibnizFormula();
		System.out.println("Using " + formular.getFormularName()
				+ " to calculate the approximate Pi number");
		// get stop input for formula
		formular.getInput(scanner);

		// Choosing formula for calculation
		piCalculation.setFormular(formular);

		System.out.println("The pi number was calculed by: "
				+ formular.getFormularName());
		System.out
				.println("If you wait too long to get result. Press enter to stop calculate");

		/*
		 * Start calculate the pi number
		 */
		long startTime = System.currentTimeMillis();
		piCalculation.startCalculate();

		// this help to show the result
		ShowResultThread showResultThread = new ShowResultThread(piCalculation,
				startTime);
		showResultThread.start();

		/*
		 * Wait user press enter to pause or stop calculate
		 */
		scanner = new Scanner(System.in);
		decideStopRunning(scanner, piCalculation, startTime);
	}

	/**
	 * Getting user input and allow helping us decide when to stop calculate
	 * 
	 * if user press enter stop calculate otherwise, it will print the current
	 * value of pi that was calculated
	 * 
	 * @param scanner
	 *            a scanner help to get input from user
	 * @param piCalculation
	 * @param t
	 */
	private static void decideStopRunning(Scanner scanner,
			PiCalculation piCalculation, long startTime) {
		String line = null;
		while (true) {
			if (!piCalculation.getThreadManager().isTerminated()) {
				line = scanner.nextLine();
				if (line.isEmpty()) {
					piCalculation.stopCalculate();
					break;
				}
			} else {
				break;
			}
		}
	}

}

class ShowResultThread extends Thread {

	private PiCalculation piCalculation;

	private long startTime;

	public ShowResultThread(PiCalculation piCalculation, long startTime) {
		this.piCalculation = piCalculation;
		this.startTime = startTime;
	}

	public void run() {
		while (true) {
			if (piCalculation.getThreadManager().isTerminated()) {
				System.out.println("\n Pi value: " + piCalculation.getResult());
				long stopTime = System.currentTimeMillis();
				System.out.println("Time taken: " + (stopTime - startTime));
				System.out.println("Please press enter to continue program");
				break;
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				System.out.print(".");
			}
		}
	}

}
