package com.joe.myvideo.util;

import java.io.IOException;

import org.springframework.http.HttpEntity;

public class HttpUtils {

/*	public static String get(String url, String host, int port, String encoding) throws IOException{
	    String result = "";
	    CloseableHttpClient httpclient =  HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet(url);
	    //httpGet.addHeader("Cookie", "BAIDUID=487D008FE5DEFE875BB556F6524B28E1:SL=0:NR=50:FG=1; sug=3;");	
	    HttpHost proxy = new HttpHost(host, port);
		RequestConfig config = RequestConfig.custom()
					           .setProxy(proxy)
				               .setConnectTimeout(CONNECT_TIME_OUT)
				               .setConnectionRequestTimeout(CONNECT_TIME_OUT)
				               .setConnectionRequestTimeout(CONNECT_TIME_OUT)
				               .build();
		httpGet.setConfig(config);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
		    HttpEntity entity = response.getEntity();
		    result = stream2String(entity.getContent(), encoding);
		    EntityUtils.consume(entity);
	        //System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    response.close();
		    httpGet.abort();
		    httpclient.close();
		}
		return result;
	}*/
}
