package edu.drexel.alan.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronizationTester {
	
	private final static Logger logger = LoggerFactory.getLogger( SynchronizationTester.class );
	
	private static long staticCounter = 0;
	
	public static synchronized void static1() {
		logger.info("Running static1");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		staticCounter++;
		logger.info("static1 Completed");
	}
	
	public static synchronized void static2() {
		logger.info("Running static2");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		staticCounter++;
		logger.info("static2 Completed");
	}
	
	public static synchronized void static3() {
		logger.info("Running static3");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		staticCounter++;		
		logger.info("static3 Completed");
	}
	
	public static synchronized long getStaticCounter() {
		logger.info("Running getStaticCounter");
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staticCounter;
	}
	
	public static void main(String[] args) {
		
		logger.info("New threads created");
		long beginTime = System.currentTimeMillis();
		
		Thread[] writers = new Thread[3];
		writers[0] = new Thread( () -> static1() );
		writers[1] = new Thread( () -> static2() );
		writers[2] = new Thread( () -> static3() );

		
		Thread[] readers = new Thread[50];
		for (int i = 0; i < 50; i ++) {
			readers[i] = new Thread( () -> getStaticCounter() );
		}
		
		for (Thread writer : writers) {
			writer.start();
		}
		
		for (Thread reader : readers) {
			reader.start();
		}
		
		
		for (Thread writer : writers) {
			try {
				writer.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Thread reader : readers) {
			try {
				reader.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("staticCounter = " + staticCounter + " Runtime is " + (endTime - beginTime) );
	}
	
	private long nonStaticCounter = 0;
	
	public void nonStatic1() {
		nonStaticCounter++;
	}
	public void nonStatic2() {
		nonStaticCounter++;
	}
	public void nonStatic3() {
		nonStaticCounter++;
	}
	
	


}
