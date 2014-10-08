package com.tma.gbst.syn.piexcercise.app;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.tma.gbst.syn.piexcercise.calculation.PiCalculation;
import com.tma.gbst.syn.piexcercise.formular.Formular;
import com.tma.gbst.syn.piexcercise.formular.LeibenizFormular;
import com.tma.gbst.syn.piexcercise.paralellprocessing.Master;

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

		System.out.println("This program is used to calculate approximate pi number.");

		
		//Define global scanner
		Scanner scanner = new Scanner(System.in);
		
		
		PiCalculation piCalculation = new PiCalculation();

		/*
		 * Define and set formular to use
		 */
		Formular formular = new LeibenizFormular();
		System.out.println("Using " + formular.getFormularName() + " to calculate the approximate Pi number");
		// get stop input for formular
		formular.getInput(scanner);

		// Choosing formular for calculation
		piCalculation.setFormular(formular);

		System.out.println("The pi number was calculed by: "
				+ formular.getFormularName());
		System.out.println("--------------------------");
		System.out.println("If you wait too long to get result. Press enter to stop calculate");

		/*
		 * Start calculate the pi number
		 */
		long startTime = System.currentTimeMillis();
		piCalculation.startCalculate();
		
		// get thread manager to top other thread anytime you want
		Master threadManager = piCalculation.getThreadManager();
		
		
		/*
		 * Show result of current Thread
		 */
		ShowResultThread showResultThread = new ShowResultThread(piCalculation, threadManager, startTime);
		showResultThread.start();
		
		/*
		 * Wait user press enter to pause or stop calculate
		 */
		scanner = new Scanner(System.in);
		decideStopRunning(scanner, piCalculation, startTime);
		scanner.close();
		

	}

	/**
	 * Getting user input and allow helping us decide when to stop calculate
	 * 
	 * if user press enter stop calculate otherwise, it will print the current value of pi that was calculated
	 * @param scanner  a scanner help to get input from user
	 * @param piCalculation  
	 * @param t
	 */
	private static void decideStopRunning(Scanner scanner, PiCalculation piCalculation, long startTime) {
		String line = null;
		while (true){
			if (!piCalculation.getThreadManager().isTerminated()){
				line = scanner.nextLine();
				if (line.isEmpty()){
					break;
				}					
			} else {
				break;
			}
		}
	}

}

/**
 * Automatically print out the pi value in another thread, so that do not block UI
 * @author tdainhan
 *
 */
class ShowResultThread extends Thread{
	
	private PiCalculation piCalculation;
	private Master master;
	private long startTime;

	public ShowResultThread(PiCalculation piCalculation, Master master, long startTime){
		this.piCalculation = piCalculation;
		this.master = master;
		this.startTime = startTime;
	}
	
	public void run(){
		while(true){
			if (!master.isTerminated()){
				System.out.printf("Current Pi value: %.16f \n", piCalculation.getResult());
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.printf("Final Pi value: %.16f \n", piCalculation.getResult());
				long stopTime = System.currentTimeMillis();
				System.out.println("Time taken: " + (stopTime - startTime));
				break;
			}
		}
	}
	
}
