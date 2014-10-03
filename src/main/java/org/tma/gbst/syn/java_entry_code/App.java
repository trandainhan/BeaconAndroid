package org.tma.gbst.syn.java_entry_code;

/**
 * <h1>Pi Calculation Program</h1>
 * This program was created to calculat the apporximate pi number
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
    	Formula formular = new LeibenizFormula();
    	piCalculation.setFormular(formular);
    	
    	System.out.println("The pi number was calculed by: " + formular.getFormulaName());
    	
    	/**
    	 * Calculte the pi number
    	 */
    	double pi = piCalculation.calculate();
    	
    	System.out.println("The approximation of Pi: " + pi);
    	
    }
    
}
