package com.example.util.http; /**
 * 
 *//*

package com.example.util.http;

import org.apache.http.HttpEntity;

import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

*/
/**
 * <desc></desc>
 * @author mupeng
 *//*

public class GetRunnable implements Runnable {
	
	private CountDownLatch countDownLatch;
	private final CloseableHttpClient httpClient;
	private final HttpGet httpget;
	private HttpEntity entity;

	public GetRunnable(CloseableHttpClient httpClient, HttpGet httpget, HttpEntity entity, CountDownLatch countDownLatch) {
		this.httpClient = httpClient;
		this.httpget = httpget;
		this.entity = entity;
		this.countDownLatch = countDownLatch;
	}
//
//	@Override
	public void run() {
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpget, HttpClientContext.create());
			entity = response.getEntity();
			if(response.getStatusLine()==null||response.getStatusLine().getStatusCode()!=200){
				entity = null;
			}
//			System.out.println(EntityUtils.toString(entity, "utf-8"));
			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			countDownLatch.countDown();
			try {
				if (response != null)
					response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}  
*/
