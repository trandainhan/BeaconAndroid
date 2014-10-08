package com.tma.gbst.syn.piexcercise.calculation;

import com.tma.gbst.syn.piexcercise.formular.Formular;
import com.tma.gbst.syn.piexcercise.paralellprocessing.Master;

/**
 * 
 * @author tdainhan
 *
 */
public class PiCalculation extends Thread {

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

	public double stopCalculate() {
		return formular.stopCalculate();
		
	}

	public double getResult(){
		return formular.getResult();
	}
	
	public Master getThreadManager(){
		return formular.getMasterThread();
	}
}
