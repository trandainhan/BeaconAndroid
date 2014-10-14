package com.tma.gbst.syn.piexcercise.formular.leibniz;

import com.tma.gbst.syn.piexcercise.formular.Result;

public class LeibnizResult implements Result {
	long n;
	double pi = 0;

	@Override
	public String toString() {
		return "PI =  with n = ";
	}

	@Override
	public void add(Result r) {
		if (r instanceof LeibnizResult) {
			LeibnizResult lr = (LeibnizResult) r;
			pi += lr.pi;
			if (lr.getN() > n) {
				n = lr.getN();
			}
		}
		
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}
	
}
