package com.zacharychao.elasticsearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

//@Service("searchClient")
public class ESSearchClient implements ISearchClient {

//	@Autowired
	private RestHighLevelClient client;

	public List<JSONObject> search(SearchRequest request) {
		try {
			SearchResponse response = client.search(request);
			SearchHits hits = response.getHits();
			List<JSONObject> list = new ArrayList<JSONObject>();
			hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString())));
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> searchString(SearchRequest request) {
		try {
			SearchResponse response = client.search(request);
			SearchHits hits = response.getHits();
			List<String> list = new ArrayList<String>();
			hits.forEach(item -> list.add(item.getSourceAsString()));
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> List<T> search(SearchRequest request, Class<T> t) {
		List<JSONObject> response = this.search(request);
		List<T> list = new ArrayList<>(response.size());
		response.forEach(item -> list.add(JSON.parseObject(JSON.toJSONString(item), t)));
		return list;
	}

	public <T> IndexResponse saveEntity(String index, String type, String id, T t) {
		IndexRequest request = new IndexRequest(index, type, id);
		request.source(JSON.toJSONString(t), XContentType.JSON);
		try {
			IndexResponse response = client.index(request);
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
