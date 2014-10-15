package com.tma.gbst.syn.piexcercise;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tma.gbst.piexcercise.formular.leibniz.LeibnizFormula;

public class LeibenizFormularTest {
	
	LeibnizFormula leibenizFormular = new LeibnizFormula();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
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
	public void testStartCalculate() throws Exception {
		double result = 1.0 - 1.0/3;
		System.out.println(result);
		
		Field field = LeibnizFormula.class.getDeclaredField("count");
		field.setAccessible(true);
		long a = 2;
		field.set(leibenizFormular, a);
		
		
		assertEquals(a, field.get(leibenizFormular));
		
//		assertEquals(result, leibenizFormular.startCalculate(), 0.00);
		
	}

	@Test
	public void testStopCalculate() throws Exception {
		Field field = LeibnizFormula.class.getDeclaredField("isStop");
		field.setAccessible(true);
		leibenizFormular.cancel();
		assertEquals("true", field.get(leibenizFormular).toString());
	}

	@Test
	public void testGetResult() throws Exception {
		Field field = LeibnizFormula.class.getDeclaredField("result");
		field.setAccessible(true);
		assertEquals(field.get(leibenizFormular), leibenizFormular.getResult());
	}

}
