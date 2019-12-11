package com.zacharychao.es.service;

import java.util.List;

public interface ISearchClient {
	List<String> searchString(String index,String type, String name, String value);
}
