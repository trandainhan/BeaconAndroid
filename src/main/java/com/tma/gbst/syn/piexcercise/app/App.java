package com.tma.gbst.syn.piexcercise.app;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.tma.gbst.syn.piexcercise.calculation.PiCalculation;
import com.tma.gbst.syn.piexcercise.formular.Formular;
import com.tma.gbst.syn.piexcercise.formular.LeibenizFormula;

/**
 * <h1>Pi Calculation Program</h1>
 * This program was created to calculate the approximate pi number
 * 
 * @author tdainhan
 * @version 1.0
 * @since 11/9/2014
 *
 */
public class App 
{
	
	/**
	 * this is main method to calculate pi number
	 * more formally, 
	 * 
	 * @param args
	 * @return nothing
	 */
    public static void main( String[] args )
    {
    	
    	System.out.println("This program is used to calculate approximate pi number.");
    	
    	PiCalculation piCalculation = new PiCalculation();
    	
    	/**
    	 * Define amd set formular to use
    	 */
    	Formular formular = new LeibenizFormula();
    	piCalculation.setFormular(formular);
    	
    	System.out.println("The pi number was calculed by: " + formular.getFormulaName());
    	
    	/**
    	 * Start calculate the pi number
    	 */
    	piCalculation.startCalculate();
    	
		System.out.print("Press any key to stop calculate, the approximation of pi will depend on thi ...");
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
