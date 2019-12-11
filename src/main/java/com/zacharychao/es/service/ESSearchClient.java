package com.zacharychao.es.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zacharychao.es.entity.SpecInfo;

@Service
public class ESSearchClient implements ISearchClient {

	@Autowired
	private TransportClient client;

	public List<String> searchString(String index,String type, String name, String value) {
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(name, value);
		SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type).setQuery(matchQueryBuilder).setSize(10);
		SearchHits hits = builder.get().getHits();
		List<String> list = new ArrayList<String>();
		hits.forEach(item -> list.add(item.getSourceAsString()));
		return list;
	}
	public List<JSONObject> search(String index,String type, String name, String value){
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(name, value);
		SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type).setQuery(matchQueryBuilder).setSize(10);
		SearchHits hits = builder.get().getHits();
		List<JSONObject> list = new ArrayList<JSONObject>();
		hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString())));
		return list;
	}
	public <T> List<T> search(String index,String type, String name, String value,Class<T> t){
		List<JSONObject> response = this.search(index, type, name, value);
		List<T> list = new ArrayList<T>();
		response.forEach(item -> list.add(JSON.parseObject(item.toJSONString(), t)));
		return list;
	}

}
