package com.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

/**
 * 无界线程池 ,使用的是固定数量的线程，无界的队列LinkedBlockingQueue的线程池
 * 类名称：LinkedThreadPool   
 * 类描述： 本线程池能有效提高程序的吞吐量，但是如果任务执行太慢或者生产者大于消费者，有系统资源耗尽的危险，适合非连续执行任务
 * @author mcl
 * 2013-06-19 上午11:19:47
 */
public class LinkedThreadPool extends ThreadPoolCore{
	
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
		executorService = Executors.newFixedThreadPool(threadNumber);
		if(logger.isInfoEnabled()){
			logger.info("==> 无界线程池 ，Thread number is " + threadNumber);
		}
	}

	//==========================================
	public void setSingleCpuThreadNumber(int singleCpuThreadNumber) {
		this.singleCpuThreadNumber = singleCpuThreadNumber;
	}

}
