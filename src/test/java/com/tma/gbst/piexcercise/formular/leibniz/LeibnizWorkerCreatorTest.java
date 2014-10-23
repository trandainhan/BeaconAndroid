package com.tma.gbst.piexcercise.formular.leibniz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tma.gbst.piexcercise.formular.Worker;

public class LeibnizWorkerCreatorTest {


	@Test
	public void testCreateNextWorker() {
		
		LeibnizWorkerCreator creator = new LeibnizWorkerCreator(1000);
		
		LeibnizWorker leibnizWorker = creator.createNextWorker();
		assertNotNull(leibnizWorker);
		
		creator = new LeibnizWorkerCreator(-1);
		leibnizWorker = creator.createNextWorker();
		assertNull(leibnizWorker);
		
		creator = new LeibnizWorkerCreator(21000);
		
		List<Worker> workers = new ArrayList<>();
		Worker worker;
		while ((worker = creator.createNextWorker()) != null) {
			workers.add(worker);
		}
		assertEquals(2, workers.size());
	}

}
