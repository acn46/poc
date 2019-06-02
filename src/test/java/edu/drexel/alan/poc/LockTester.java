package edu.drexel.alan.poc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LockTester {
	
	private final static Logger logger = LoggerFactory.getLogger( LockTester.class );
	
	private static long staticCounter = 0;
	
	//Controls the read write of staticCounter
	private static ReadWriteLock lock = new ReentrantReadWriteLock(); 
	private static Lock writeLock = lock.writeLock();
	private static Lock readLock = lock.readLock();
	
	public static void static1() {
		logger.info("Running static1");
		writeLock.lock();
		try {
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			staticCounter++;
		} finally { 
			writeLock.unlock(); 
		}
		logger.info("static1 Completed");
	}
	
	public static void static2() {
		logger.info("Running static2");
		writeLock.lock();
		try {
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			staticCounter++;
		} finally { 
			writeLock.unlock(); 
		}
		logger.info("static2 Completed");
	}
	
	public static void static3() {
		logger.info("Running static3");
		writeLock.lock();
		try {
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			staticCounter++;
		} finally { 
			writeLock.unlock(); 
		}
		logger.info("static3 Completed");
	}

	public static long getStaticCounter() {
		logger.info("Running getStaticCounter");
		readLock.lock();
		try {
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return staticCounter;
		} finally {
			readLock.unlock();
		}
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
