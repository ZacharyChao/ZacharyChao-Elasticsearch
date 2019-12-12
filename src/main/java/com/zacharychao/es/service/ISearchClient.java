package com.zacharychao.es.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface ISearchClient {
	List<String> searchString(String index,String type, String name, String value);
	List<JSONObject> search(String index,String type, String name, String value);
	<T>List<T> search(String index,String type, String name, String value,Class<T> t);
	<T> String insert(String index,String type, T t);
	String deleteDoc(String index, String type, String id);
}
