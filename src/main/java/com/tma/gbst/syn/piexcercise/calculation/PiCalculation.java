package com.tma.gbst.syn.piexcercise.calculation;

import java.util.concurrent.ExecutionException;
import org.tma.gbst.syn.piexcercise.formular.Formular;

/**
 * 
 * @author tdainhan
 *
 */
public class PiCalculation extends Thread{
	
	private Formular formular;
	
	public PiCalculation() {}
	
	public PiCalculation(Formular formula){
		this.formular = formula;
	}
	
	public void setFormular(Formular formular){
		this.formular = formular;
	}
	
	public void startCalculate(){
		
		new Thread(new Runnable() {
			public void run() {
				formular.startCalculate();
			}
		}).start();
		
	}


	public Double stopCalculate() throws InterruptedException, ExecutionException{
		formular.stopCaculate();
		
		return formular.getResult();
	}

}
