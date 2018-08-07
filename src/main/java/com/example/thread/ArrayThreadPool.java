package com.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 有界线程池,使用的是固定数量的线程，有界的队列ArrayBlockingQueue的线程池
 * 类名称：ArrayThreadPool   
 * 类描述： 本线程池能有效防止系统资源耗尽，但是如果任务执行太慢或者总生产者大于消费者，后续任务会出现阻塞，降低程序的吞吐量，，适合连续执行任务
 * @author mcl
 * 2013-06-19 上午11:19:47
 */
public class ArrayThreadPool extends ThreadPoolCore{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//每个cpu同时执行的线程数
	private int singleCpuThreadNumber;
	//当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
	private long keepAliveTime;
	//有界队列长度
	private int queueLength;
	//由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。
	private RejectedExecutionHandler rejectedExecutionHandler;
	//rejectedExecutionHandler默认处理方案等待的时间，单位秒
	private int intervalSeconds;
	
	public void init(){
		/**
		 * 内核数量 * singleCpuThreadNumber
		 */
		int threadNumber = getAvailableProcessors() * singleCpuThreadNumber;
		
		//由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。默认重新放入线程池
		if (rejectedExecutionHandler == null) {
			rejectedExecutionHandler = new RejectedExecutionHandler(){
				@SuppressWarnings("rawtypes")
				@Override
				public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
					if (((ArrayBlockingQueue)executor.getQueue()).remainingCapacity() == 0) {
						try {
							TimeUnit.SECONDS.sleep(intervalSeconds);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
						executor.execute(r);
					}
				}
    		};
		}
		executorService = new ThreadPoolExecutor(
				threadNumber, threadNumber, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueLength), rejectedExecutionHandler);
		if(logger.isInfoEnabled()){
			logger.info("==> 有界线程池， Thread number is " + threadNumber);
		}
	}
	
	//==========================================
	public void setSingleCpuThreadNumber(int singleCpuThreadNumber) {
		this.singleCpuThreadNumber = singleCpuThreadNumber;
	}

	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}

	public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
		this.rejectedExecutionHandler = rejectedExecutionHandler;
	}

	public void setIntervalSeconds(int intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

}
