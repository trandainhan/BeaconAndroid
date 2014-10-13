package com.tma.gbst.syn.piexcercise.calculation;

import com.tma.gbst.syn.piexcercise.formular.Formular;
import com.tma.gbst.syn.piexcercise.paralellprocessing.Master;

/**
 * Using concrete formula to calculate
 * @author tdainhan
 *
 */
public class PiCalculation extends Thread {
	
	public final String CLASS_NAME = this.getClass().getSimpleName();

	private Formular formular;

	public PiCalculation() {
	}

	/**
	 * Construct <tt>PiCalculation</tt> with a specific formular
	 * 
	 * @param formular
	 *            a specific formular
	 */
	public PiCalculation(Formular formular) {
		this.formular = formular;
	}

	/**
	 * set formular for the calcultion
	 * 
	 * @param formular
	 */
	public void setFormular(Formular formular) {
		this.formular = formular;
	}

	/**
	 * Using multi thread to start to calculate pi number
	 */
	public void startCalculate() {
		formular.startCalculate();
	}

	/**
	 * Stop calculate pi number intermediately
	 * @return double  the result after calculate
	 */
	public double stopCalculate() {
		return formular.stopCalculate();
		
	}

	/**
	 * get the result of pi value
	 * @return double  the result of pi value
	 */
	public double getResult(){
		return formular.getResult();
	}
	
	/**
	 * get the <tt>Master</tt> thread that manage to run the calculation
	 * @return <tt>Master</tt>  a master thread that manage to run the calculation
	 */
	public Master getThreadManager(){
		return formular.getMasterThread();
	}
}
