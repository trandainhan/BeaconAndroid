package com.tma.gbst.syn.piexcercise.formular.leibniz;

public class LeibnizWorkerCreator implements WorkerCreator {
	slice = 10000;
	n, 
	lastIndex = -1;
	
	LeibnizWorker createNextWorker() {
		new LeibnizWorker(lastIndex + 1, lastIndex + 10000)
		lastIndex = lastIndex + 10000;
	}
}
