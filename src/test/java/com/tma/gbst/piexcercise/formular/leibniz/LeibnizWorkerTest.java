package com.tma.gbst.piexcercise.formular.leibniz;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeibnizWorkerTest {

	@Test
	public void testCall() throws Exception {
		LeibnizWorker leibnizWorker = new LeibnizWorker(0, 0);

		LeibnizResult lr = (LeibnizResult) leibnizWorker.call();

		assertEquals(4.0, lr.getPi(), 1);

		leibnizWorker.setBegin(0);
		leibnizWorker.setEnd(2);

		lr = (LeibnizResult) leibnizWorker.call();
		assertEquals(2.67, lr.getPi(), 2);
	}

}
