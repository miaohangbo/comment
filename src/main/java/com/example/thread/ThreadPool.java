package com.example.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface ThreadPool {
	
	/**
	 * 获取executorService
	 * @return
	 */
	public <T> T getExecutorService();
	
	/**
	 * 执行
	 * @param runnable
	 */
	public void execute(Runnable runnable);
	
	/**
	 * 执行
	 * @param callable
	 * @return
	 */
	@SuppressWarnings({ "rawtypes"})
	public <T> Future<T> submit(Callable callable);
	
	/**
	 * 执行
	 * @param runnable
	 * @param result
	 * @return
	 */
	public <T> Future<T> submit(Runnable runnable, Object result);
	
	/**
	 * 获取队列
	 * @return
	 */
	public <T> BlockingQueue<T> getQueue();
}