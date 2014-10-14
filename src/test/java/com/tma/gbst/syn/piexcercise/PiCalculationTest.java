package com.tma.gbst.syn.piexcercise;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tma.gbst.syn.piexcercise.calculation.PiCalculation;
import com.tma.gbst.syn.piexcercise.formular.leibniz.LeibnizFormula;

public class PiCalculationTest {
	
	static LeibnizFormula leibenizFormular;
	static PiCalculation PiCalculation;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		leibenizFormular = Mockito.mock(LeibnizFormula.class);
		PiCalculation = new PiCalculation();
		PiCalculation.setFormular(leibenizFormular);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetFormular() {
	}

	@Test
	public void testStartCalculate() {
		
		PiCalculation.startCalculate();
//		assertTrue(t.isAlive());
		
	}

	@Test
	public void testStopCalculate() {
		Double a = 2.3;
		Mockito.when(leibenizFormular.stopCalculate()).thenReturn(a);
		assertEquals(a, PiCalculation.stopCalculate(), 0.0);
	}

	@Test
	public void testGetResult() {
		Double a = 343.23425;
		Mockito.when(leibenizFormular.getResult()).thenReturn(a);
		assertEquals(a, PiCalculation.getResult(), 000.000);
	}

}
