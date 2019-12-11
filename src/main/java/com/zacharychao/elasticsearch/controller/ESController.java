package com.zacharychao.elasticsearch.controller;

import java.util.List;
import java.util.UUID;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zacharychao.elasticsearch.entity.SpecInfo;
import com.zacharychao.elasticsearch.service.ISearchClient;

//@Controller

public class ESController {
	public final static String INDEX = "specinfo"; 
	public final static String TYPE = "doc";
//	@Autowired
	private ISearchClient iSearchClient;
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "*********";
	}
	@RequestMapping("/index")
	@ResponseBody
	public void index() {
		SpecInfo info = new SpecInfo();
		info.setSpecid("d5fb7b1bd82c11e8b64e0242ac120002");
		info.setSpeccode("HG 2559-1994");
		info.setSpecname("化肥催化剂产品分类、型号和命名");
		info.setSpectype("强制性");
		info.setStatus("作废");
		info.setState("中国");
		info.setCategorate("行业标准");
		info.setIsproductstandard(false);
		info.setReleasestatus("toberelease");
		IndexResponse saveEntity = iSearchClient.saveEntity(INDEX, TYPE,UUID.randomUUID().toString(), info);
		System.out.println(saveEntity.getId());
		
	}
	@RequestMapping("/specinfos")
	@ResponseBody
	public List<SpecInfo> getSpecinfos(){
		SearchRequest request = new SearchRequest();
		SearchSourceBuilder builder = new SearchSourceBuilder();
		MatchPhraseQueryBuilder mqb1 = QueryBuilders.matchPhraseQuery("spectype", "强制性");
		QueryBuilder qb = QueryBuilders.boolQuery().must(mqb1);
		builder.query(qb);
		request.source(builder);
		request.indices(INDEX);
		request.types(TYPE);
		List<SpecInfo> search = iSearchClient.search(request, SpecInfo.class);
		System.out.println(search);
		return search;
	}
}
