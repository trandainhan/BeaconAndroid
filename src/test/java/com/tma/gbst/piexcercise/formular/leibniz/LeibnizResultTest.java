package com.tma.gbst.piexcercise.formular.leibniz;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeibnizResultTest {

	@Test
	public void testAdd() {
		LeibnizResult leibnizResult = new LeibnizResult(4.0, 0);

		LeibnizResult addedResult = new LeibnizResult(2, 123);

		leibnizResult.add(addedResult);

		assertEquals(6.0, leibnizResult.getPi(), 1);
		assertEquals(123, leibnizResult.getN());

		LeibnizResult addedResult2 = new LeibnizResult(1.0, 12);

		leibnizResult.add(addedResult2);

		assertEquals(123, leibnizResult.getN());
	}

}
