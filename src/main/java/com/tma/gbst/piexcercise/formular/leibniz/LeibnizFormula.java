package com.tma.gbst.piexcercise.formular.leibniz;

import com.tma.gbst.piexcercise.formular.Formula;
import com.tma.gbst.piexcercise.formular.Master;
import com.tma.gbst.piexcercise.formular.Result;
import com.tma.gbst.piexcercise.formular.WorkerCreator;

/**
 * This  class define the leibniz formula
 * 
 * @author tdainhan
 * @version 1.0
 * @since 10/9/2014
 */
public class LeibnizFormula  implements Formula {
	
	private static final String NAME = "Leibeniz Formula";
	
	private long count;
	
	private Master master;
	private WorkerCreator workerCreator;
	
	/**
	 * Construct a Leibniz Formula
	 */
	public LeibnizFormula(){};

	/**
	 * Start to calculate pi number follow it's formula
	 */
	public void calculate() {
		LeibnizResult leibnizResult = new LeibnizResult();
		workerCreator = new LeibnizWorkerCreator(count);
		master = new Master(workerCreator, leibnizResult);
		master.process();
	}
	
	@Override
	public void setParameters(String[] parameters) {
		String para = parameters[0];
		this.count = Long.parseLong(para);
	}
	
	/**
	 * Stop to calculate pi number by this formula
	 */
	public void cancel() {
		master.shutdown();
	}
	
	/**
	 * Get Pi number at current time, make sure you have start to calculate, otherwise
	 * it will return 0.0
	 */
	public Result getResult(){
		return master.getResult();
	}

	/**
	 * Get formula name
	 */
	public String getFormularName(){
		return NAME;
	}

}
