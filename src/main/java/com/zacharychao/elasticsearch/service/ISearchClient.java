package com.zacharychao.elasticsearch.service;

import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;

import com.alibaba.fastjson.JSONObject;

public interface ISearchClient {
	List<JSONObject> search(SearchRequest request);
	List<String> searchString(SearchRequest request);
	<T> List<T> search(SearchRequest request,Class<T> t);
	<T> IndexResponse saveEntity(String index,String type,String id ,T t);
}
