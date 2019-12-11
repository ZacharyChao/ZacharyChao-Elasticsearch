package com.zacharychao.es.config;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ElasticsearchConfig {
	@Bean
	public TransportClient client() {
		return getESDecorator().getClient();
	}
	@Bean
	@Scope("singleton")
	public ESDecorator getESDecorator() {
		return new ESDecorator();
	}
}
