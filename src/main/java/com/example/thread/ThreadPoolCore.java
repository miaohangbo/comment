package com.example.thread;

import java.util.concurrent.*;

public class ThreadPoolCore implements ThreadPool{
	
	protected ExecutorService executorService = null;
	private int availableProcessors = -1;
	
	/**
	 * 获取cpu核数
	 * @return
	 */
	public int getAvailableProcessors(){
		if (availableProcessors == -1) {
			availableProcessors = Runtime.getRuntime().availableProcessors();
		}
		return availableProcessors;
	}
	
	/**
	 * 执行
	 * @param runnable
	 */
	public void execute(Runnable runnable){
		executorService.execute(runnable);
	}
	
	/**
	 * 执行
	 * @param callable
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> Future<T> submit(Callable callable){
		return (Future<T>)executorService.submit(callable);
	}
	
	/**
	 * 执行
	 * @param runnable
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Future<T> submit(Runnable runnable, Object result){
		return (Future<T>) executorService.submit(runnable, result);
	}
	
	/**
	 * 获取executorService
	 * @return
	 */
	public <T> T getExecutorService() {
		return (T)executorService;
	}

	/**
	 * 获取队列
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> BlockingQueue<T> getQueue(){
		return (BlockingQueue<T>) ((ThreadPoolExecutor)executorService).getQueue();
	}

}
