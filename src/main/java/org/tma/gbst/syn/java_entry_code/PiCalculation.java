package org.tma.gbst.syn.java_entry_code;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author tdainhan
 *
 */
public class PiCalculation {
	
	private Formula formular;
	private ArrayList<Formula> formulars = new ArrayList<Formula>();
	
	public PiCalculation() {}
	
	public PiCalculation(Formula formula){
		this.formular = formula;
	}
	
	public PiCalculation(ArrayList<Formula> formulas){
		this.formulars = formulas;
	}
	
	public void deleteAllFormular(){
		this.formulars.clear();
	}
	
	public void setFormular(Formula formular){
		this.formular = formular;		
	}
	
	public void setFormulars(ArrayList<Formula> formulas){
		this.formulars = formulas;
	}
	
	public void addFormular(Formula formula){
		this.formulars.add(formula);
	}
	
	public double calculate(){
		return formular.calculate();
	}
	
	
	/**
	 * This method is used to calculate the pi number with many formula
	 * @return Arraylist<Double>  
	 */
	public ArrayList<Double> calculates(){
		ArrayList<Double> results = new ArrayList<Double>();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<Double>> futures = new ArrayList<Future<Double>>();
		
		for (int i = 0; i < formulars.size(); i++){
			CaculateFormularCallable calculateFormularCallable = new CaculateFormularCallable(formulars.get(i));
			
			Future<Double> future = executor.submit(calculateFormularCallable);
			futures.add(future);
		}
		
		executor.shutdown();
		
		for (int i = 0; i < formulars.size(); i++){
			try {
				results.add(futures.get(i).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		return results;
	}
	
	class CaculateFormularCallable implements Callable<Double>{
		
		private Formula formular;
		
		public CaculateFormularCallable(){
			
		}
		
		public CaculateFormularCallable(Formula formular){
			this.formular = formular;
		}

		public Double call() throws Exception {
			return formular.calculate();
		}
		
	}

}
