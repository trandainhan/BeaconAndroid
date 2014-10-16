package com.tma.gbst.piexcercise.formular;

/**
 * The {@code Formula} interface provide the way to any formula can implement it
 */
public interface Formula {
	
	/**
	 * Get the name of formula.
	 * 
	 * @return string  the name of formula.
	 */
	public String getFormularName();

	/**
	 * Set parameters for a formula.
	 * 
	 * @param parameters  the parameters for formula.
	 */
	public void setParameters(String[] parameters);
	
	/**
	 * Starting to calculate pi number by this formula.
	 */
	public void calculate();
	
	/**
	 * Stop calculate pi number at any time as you want.
	 */
	public void cancel();
	
	/**
	 * Return the result of pi number after calculate.
	 * 
	 * @return Result  the result of pi.
	 */
	public Result getResult();
	
}
