package com.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 无界线程池 ,使用的是固定数量的线程，无界的队列的线程池
 * 类名称：ScheduledThreadPool   
 * 类描述： 本线程池能有效提高程序的吞吐量，但是如果任务执行太慢或者生产者大于消费者，有系统资源耗尽的危险，适合非连续执行任务
 * @author mcl
 * 2013-06-19 上午11:19:47
 */
public class ScheduledThreadPool extends ThreadPoolCore{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//每个cpu同时执行的线程数
	private int singleCpuThreadNumber;
	
	public void init(){
		/**
		 * 内核数量 * singleCpuThreadNumber
		 */
		int threadNumber = getAvailableProcessors() * singleCpuThreadNumber;
		/**
		 * 处理阻塞发生几率比较的大任务时，线程数可以设置大一些
		 */
		executorService = Executors.newScheduledThreadPool(threadNumber);
		if(logger.isInfoEnabled()){
			logger.info("==> 任务线程池 ，Thread number is " + threadNumber);
		}
	}

	//==========================================
	public void setSingleCpuThreadNumber(int singleCpuThreadNumber) {
		this.singleCpuThreadNumber = singleCpuThreadNumber;
	}
	
	public ScheduledExecutorService getScheduledExecutorService() {
	    return (ScheduledExecutorService)executorService;
    }

	/**
	 *  创建并执行在给定延迟后启用的一次性操作
	 * @param command
	 * @param delay
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit){
	    return getScheduledExecutorService().schedule(command, delay, unit);
	}
	
	/**
	 *  创建并执行在给定延迟后启用的 ScheduledFuture
	 * @param callable
	 * @param delay
	 * @param unit
	 * @return
	 */
	public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit){
	    return getScheduledExecutorService().schedule(callable, delay, unit);
	}
	
	/**
	 * 每隔N段时间执行一次，如果执行时间超过N时间，那么间隔以执行时间为准
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit){
	    return getScheduledExecutorService().scheduleAtFixedRate(command, initialDelay, period, unit);
	}
	
	/**
	 * 每隔N段时间执行一次，如果执行时间超过N时间，那么间隔以执行时间+N时间为准
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit){
        return getScheduledExecutorService().scheduleWithFixedDelay(command, initialDelay, period, unit);
    }
}
