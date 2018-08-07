package com.example.util.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadFactory {
	
	private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();

	public static void exec(Runnable run) {
		fixedThreadPool.execute(run);
	}

	public static void destory() {
		fixedThreadPool.shutdown();
	}
}
