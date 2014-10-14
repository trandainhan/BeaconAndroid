package com.tma.gbst.syn.piexcercise.calculation;

import com.tma.gbst.syn.piexcercise.formular.Formula;
import com.tma.gbst.syn.piexcercise.formular.Master;

/**
 * Using concrete formula to calculate.
 * 
 * @author tdainhan
 *
 */
public class PiCalculation extends Thread {
	
//	public final String CLASS_NAME = this.getClass().getSimpleName();

	private Formula formula;

	public PiCalculation() {
	}

	/**
	 * Construct <tt>PiCalculation</tt> with a specific formula
	 * 
	 * @param formula a specific formula
	 */
	public PiCalculation(Formula formula) {
		this.formula = formula;
	}

	/**
	 * set formula for the calculation
	 * 
	 * @param formula
	 */
	public void setFormular(Formula formula) {
		this.formula = formula;
	}

	/**
	 * Using multi thread to start to calculate pi number
	 */
	public void startCalculate() {
		formula.startCalculate();
	}

	/**
	 * Stop calculate pi number intermediately
	 * @return double  the result after calculate
	 */
	public double stopCalculate() {
		return formula.stopCalculate();
		
	}

	/**
	 * get the result of pi value
	 * @return double  the result of pi value
	 */
	public double getResult(){
		return formula.getResult();
	}
	
	/**
	 * get the <tt>Master</tt> thread that manage to run the calculation
	 * @return <tt>Master</tt>  a master thread that manage to run the calculation
	 */
	public Master getThreadManager(){
		return formula.getMasterThread();
	}
}
