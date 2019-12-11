package com.zacharychao.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ESDecorator implements InitializingBean,DisposableBean{
	private RestHighLevelClient client;
	
	private HttpHost host;
	
	public ESDecorator(HttpHost host) {
		this.host = host;
	}
	
	public RestHighLevelClient getRestHighLevelClient() {
		if(client == null) {
			client = new RestHighLevelClient(RestClient.builder(host));
		}
		return client;
	}
	public void destroy() throws Exception {
		client.close();
	}

	public void afterPropertiesSet() throws Exception {
		client = new RestHighLevelClient(RestClient.builder(host));
	}

}
