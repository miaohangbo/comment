package com.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 快速线程池，计算线程池，本线程池线程较少，线程优先级非常高，适合计算类非阻塞场合使用，能有效利用cpu性能
 * 类名称：FastThreadPool   
 * 类描述： 适合所有计算类不阻塞的任务执行，但是线程优先级高并不代表线程一定会优先于低等级线程运行（多核cpu更不可测）
 * @author mcl
 * 2013-06-19 上午11:19:47
 */
public class FastThreadPool extends LinkedThreadPool{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void init(){
		/**
		 * 内核数量
		 */
		int threadNumber = getAvailableProcessors() + 1;
		/**
		 * 处理阻塞发生几率比较的大任务时，线程数可以设置大一些
		 */
		executorService = Executors.newFixedThreadPool(threadNumber);
		if(logger.isInfoEnabled()){
			logger.info("==> 快速线程池 ，Thread number is " + threadNumber);
		}
	}
	
	public void execute(Runnable runnable){
		Thread thread = new Thread(runnable);
		thread.setPriority(Thread.MAX_PRIORITY);
		super.execute(thread);
	}
	
	public <T> Future<T> submit(Runnable runnable, Object result){
		Thread thread = new Thread(runnable);
		thread.setPriority(Thread.MAX_PRIORITY);
		return super.submit(thread, result);
	}
}
