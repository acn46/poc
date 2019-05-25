package edu.drexel.alan.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTester {

	private final static Logger logger = LoggerFactory.getLogger( ThreadTester.class );
	
	public static void main(String[] args) {
		ThreadTester tester = new ThreadTester();
		long beginTime = System.currentTimeMillis();
		
		//executeSequentially(tester);
		//executeManualThread(tester);
		executePoolThread(tester);
		
		long endTime = System.currentTimeMillis();
		logger.info("Runtime = " + (endTime - beginTime) );
	}

	private static void executeSequentially(ThreadTester tester) {
		for (int i = 0; i < 10; i++) {
			tester.longRunningMethod1();
			tester.longRunningMethod2(7);
			tester.longRunningMethod3(10);
		}
	}
	
	private static void executeManualThread(ThreadTester tester) {
		//Build task list
		List<Runnable> list = new ArrayList<>(); 
		for (int i = 0; i < 500; i++) {
			Runnable r = ( () -> tester.longRunningMethod1() );
			Runnable r2 = ( () -> tester.longRunningMethod2(7) );
			Runnable r3 = ( () -> tester.longRunningMethod3(10));
			
			list.add(r);
			list.add(r2);
			list.add(r3);
		}
		
		//Assign tasks to threads
		List<Thread> threads = new ArrayList<>();
		for (Runnable r : list) {
			Thread thread = new Thread(r);
			threads.add(thread);
			thread.start();
		}
		
		//Ask main to wait
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static void executePoolThread(ThreadTester tester) {
		//Build task list
		List<Runnable> list = new ArrayList<>(); 
		for (int i = 0; i < 2000; i++) {
			Runnable r = ( () -> tester.longRunningMethod1() );
			Runnable r2 = ( () -> tester.longRunningMethod2(7) );
			Runnable r3 = ( () -> tester.longRunningMethod3(10));
			
			list.add(r);
			list.add(r2);
			list.add(r3);
		}
		logger.info("Finished with building list of runnables.");
		
		//Assign tasks to threads
		ExecutorService executor = Executors.newFixedThreadPool(750);
		CompletionService completionService = new ExecutorCompletionService(executor);
		
		for (Runnable r : list) {
			completionService.submit(r, null);
		}
		logger.info("All tasks submitted.");

		//shutdown sequence
		shutdownSequence(executor);
		logger.info("Shutdown complete.");
	}

	private static void shutdownSequence(ExecutorService executor) {
		logger.info("Stop accepeting tasks");
		executor.shutdown(); //do not accept more tasks
		
		try {
			//allow tasks to complete
			logger.info("Allow time for tasks to complete.");
			if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
				logger.info("Forceful shutdown");
				executor.shutdownNow(); //cancel all threads, allow time to cancel
				logger.info("Allow more time for tasks to complete.");
				if (!executor.awaitTermination(100, TimeUnit.SECONDS)) { //if all are still not done
					logger.error("executor did not terminate in time"); 
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			executor.shutdownNow();
		}
	}
	
	public void longRunningMethod1() {
		logger.info("longRunningMethod1 -- running...");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("longRunningMethod1 -- done");
	}
	
	public int longRunningMethod2(int sleepTime) {
		logger.info("longRunningMethod2 -- running...");
		try {
			Thread.sleep(sleepTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("longRunningMethod2 -- done");
		return 1;
	}
	
	public int longRunningMethod3(int sleepTime) {
		logger.info("longRunningMethod3 -- running...");
		try {
			Thread.sleep(sleepTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("longRunningMethod3 -- done");
		return 1;
	}

}
