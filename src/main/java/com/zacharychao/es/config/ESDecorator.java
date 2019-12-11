package com.zacharychao.es.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ESDecorator implements InitializingBean,DisposableBean{
	
	private TransportClient transportClient;
	
	private static Settings settings;
	
	private static void initSetting() {
		settings=Settings.builder().put("cluster.name","docker-cluster").build();
	}
	
	public TransportClient getClient()  {
		if(transportClient == null) {
			if(settings == null) {
				initSetting();
			}
			transportClient=new PreBuiltTransportClient(settings);
			try {
				transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.232.215"),9300));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return transportClient;
	}

	@Override
	public void destroy() throws Exception {
		transportClient.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(settings == null) {
			initSetting();
		}
		transportClient=new PreBuiltTransportClient(settings);
		transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.232.215"),9300));
	}
	
}
