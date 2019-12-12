package com.zacharychao.es.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zacharychao.es.entity.SpecInfo;

@Service
public class ESSearchClient implements ISearchClient {

	@Autowired
	private TransportClient client;

	public List<String> searchString(String index,String type, String name, String value) {
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//		MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery(keyword, "specInfo.speccode","specInfo.specname");
		MatchPhraseQueryBuilder nameMatchPhraseQuery = QueryBuilders.matchPhraseQuery(name, value);
//		MatchPhraseQueryBuilder codeMatchPhraseQuery = QueryBuilders.matchPhraseQuery("specInfo.speccode",keyword);
//		MatchQueryBuilder matchQueryBuilder = ;
		boolQuery.must(nameMatchPhraseQuery);
		SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type).setQuery(boolQuery);
		SearchHits hits = builder.get().getHits();
		List<String> list = new ArrayList<String>();
		hits.forEach(item -> list.add(item.getSourceAsString()));
		System.out.println(list);
		return list;
	}
	public List<JSONObject> search(String index,String type, String name, String value){
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(name, value);
		SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type).setQuery(matchQueryBuilder);
		SearchHits hits = builder.get().getHits();
		List<JSONObject> list = new ArrayList<JSONObject>();
		hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString())));
		System.out.println(list);
		return list;
	}
	public <T> List<T> search(String index,String type, String name, String value,Class<T> t){
		List<JSONObject> response = this.search(index, type, name, value);
		List<T> list = new ArrayList<T>();
		response.forEach(item -> list.add(JSON.parseObject(item.toJSONString(), t)));
		System.out.println(list);
		return list;
	}
	@Override
	public <T> String insert(String index, String type, T t) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String source = mapper.writeValueAsString(t);
			IndexResponse response = client.prepareIndex(index, type).setSource(source, XContentType.JSON).get();
			if(response != null) {
				return response.getId();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String deleteDoc(String index, String type, String id) {
		
		return client.prepareDelete(index, type, id).get().getId();
	}

}
