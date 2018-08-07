package com.example.util.http; /**
 * 
 *//*

package com.example.util.http;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

*/
/**
 * <desc></desc>
 * @author mupeng
 *//*

public class HttpExecute {
	
	public static void main(String[] args) {
		HttpGet post = new HttpGet("https://graph.qq.com/oauth2.0/me?access_token=F86A26ABA69084D65A51F49D0ADDA1EF&unionid=1");
		String string = new HttpExecute().execToString(post);
		System.out.println(string);
	}
	
	*/
/**
	 * 最大连接数
	 *//*

	private final int MAX_TOTAL_CONNECTIONS = 800;
	*/
/**
	 * 每个路由最大连接数
	 *//*

	private final int MAX_ROUTE_CONNECTIONS = 40;
	*/
/**
	 * 连接超时时间
	 *//*

	private final static int REQUEST_TIMEOUT = 30 * 1000;
	
	*/
/**
	 * 设置等待数据超时时间
	 *//*

	private final static int SO_TIMEOUT = 100 * 1000;
	
	*/
/**
	 * 返回response
	 *//*

	private CloseableHttpResponse response = null;

	public String execToString(HttpUriRequest request) {
		HttpEntity entity = getHttpClient(request);
		if (entity == null) {
			return null;
		}
		String data = null;
		try {
			data = EntityUtils.toString(entity, Consts.UTF_8.toString());
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	

	public void execForNotResult(HttpUriRequest request) {
		HttpEntity entity = getHttpClient(request);
		if(entity==null){
			return;
		}
		if (response != null){
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	*/
/**
	 * 生成HttpClient
	 * 
	 * @param request
	 * @return
	 *//*

	private HttpEntity getHttpClient(HttpUriRequest request) {
		HttpEntity entity = null;
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();  
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();  
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()  
                .register("http", plainsf)  
                .register("https", sslsf)  
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        // 将最大连接数增加到200  
        cm.setMaxTotal(this.MAX_TOTAL_CONNECTIONS);  
        // 将每个路由基础的连接增加到20  
        cm.setDefaultMaxPerRoute(this.MAX_ROUTE_CONNECTIONS);
        	        
        // 将目标主机的最大连接数增加到50  
        HttpHost httpHost = new HttpHost(request.getURI().getHost(),request.getURI().getPort());
        cm.setMaxPerRoute(new HttpRoute(httpHost), 50);  
        //请求重试处理 
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount,
					HttpContext httpcontext) {
				if (executionCount >= 5) {// 如果已经重试了5次，就放弃
					return false;
				}
				if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
					return true;
				}
				if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
					return false;
				}
				if (exception instanceof InterruptedIOException) {// 超时
					return false;
				}
				if (exception instanceof UnknownHostException) {// 目标服务器不可达
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
					return false;
				}
				if (exception instanceof SSLException) {// ssl握手异常
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(httpcontext);
				HttpRequest request = clientContext.getRequest();
				// 如果请求是幂等的，就再次尝试
				if (!(request instanceof HttpEntityEnclosingRequest)) {
					return true;
				}
				return false;
			}  
        };
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)  
                .setRetryHandler(httpRequestRetryHandler)  
                .build();
        
        HttpGet httpget = new HttpGet(request.getURI());  
        config(httpget);
		try {
			response = httpClient.execute(httpget, HttpClientContext.create());
			if(response.getStatusLine()==null||response.getStatusLine().getStatusCode()!=200){
				entity = null;
			}else {
				entity = response.getEntity();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
//      long start = System.currentTimeMillis();
        */
/*try {
            ExecutorService executors = Executors.newSingleThreadExecutor();  
            CountDownLatch countDownLatch = new CountDownLatch(1);
            HttpGet httpget = new HttpGet(request.getURI());  
            config(httpget);
            //启动线程抓取  
            executors.execute(new GetRunnable(httpClient, httpget, entity, countDownLatch));  
            countDownLatch.await();  
            executors.shutdown();
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } finally {  
            //System.out.println("线程" + Thread.currentThread().getName() + "," + System.currentTimeMillis() + ", 所有线程已完成，开始进入下一步！");  
        }*//*

        //long end = System.currentTimeMillis();  
        //System.out.println("consume -> " + (end - start));  
		return entity;
	}
	
	private void config(HttpRequestBase httpRequestBase) {
		httpRequestBase.setProtocolVersion(HttpVersion.HTTP_1_1);
		httpRequestBase.setHeader("User-Agent", "HttpComponents/1.1");
		httpRequestBase.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,**/

/*;q=0.8");
		httpRequestBase.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");// "en-US,en;q=0.5");
		httpRequestBase.setHeader("Accept-Charset","ISO-8859-1,utf-8,gbk,gb2312;q=0.7,*;q=0.7");
		httpRequestBase.setHeader("Connection", "keep-alive");
		httpRequestBase.setHeader("Keep-Alive", "300");
		
		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom()
				.setExpectContinueEnabled(true)
				.setConnectionRequestTimeout(SO_TIMEOUT)
				.setConnectTimeout(REQUEST_TIMEOUT)
				.setSocketTimeout(REQUEST_TIMEOUT)
				.build();
		httpRequestBase.setConfig(requestConfig);
	}
}
*/
