package com.tma.gbst.syn.piexcercise.calculation;

import java.util.concurrent.ExecutionException;

import com.tma.gbst.syn.piexcercise.formular.Formular;

/**
 * 
 * @author tdainhan
 *
 */
public class PiCalculation extends Thread{
	
	private Formular formular;
	
	public PiCalculation() {}
	
	/**
	 * Construct <tt>PiCalculation</tt> with a specific formular
	 * 
	 * @param formular  a specific formular 
	 */
	public PiCalculation(Formular formular){
		this.formular = formular;
	}
	
	/**
	 * set formular for the calcultion
	 * 
	 * @param formular  
	 */
	public void setFormular(Formular formular){
		this.formular = formular;
	}
	
	/**
	 * Using thread to start to calculate pi number
	 */
	public Thread startCalculate(){
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				formular.startCalculate();
			}
		});
		
		t.start();
		return t;
	}


	public double stopCalculate() throws InterruptedException, ExecutionException{
		return formular.stopCalculate();
	}
	
	public double getResult(){
		return formular.getResult();
	}

}
