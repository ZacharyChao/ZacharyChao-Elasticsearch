package com.zacharychao.es.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zacharychao.es.entity.SpecInfo;
import com.zacharychao.es.service.ISearchClient;

@Controller
public class ESController {
	private static final String INDEX = "specinfo";
	
	private static final String TYPE = "doc";
	@Autowired
	private ISearchClient iSearchClient;
	@RequestMapping("/query")
	@ResponseBody
	public List<String> matchQuery(){
		List<String> list = iSearchClient.searchString(INDEX, TYPE, "specname", "测试2019-12-12");
		return list;
	}
	
	@RequestMapping("/queryjson")
	@ResponseBody
	public List<JSONObject> matchQueryJSONObject(){
		List<JSONObject> list = iSearchClient.search(INDEX, TYPE, "specname", "化肥催化剂产品分类、型号和命名");
		return list;
	}
	
	@RequestMapping("/queryspecinfo")
	@ResponseBody
	public List<SpecInfo> matchQueryObject(){
		List<SpecInfo> list = iSearchClient.search(INDEX, TYPE, "specname", "测试2019-12-12",SpecInfo.class);
		return list;
	}
	@RequestMapping("/insert")
	@ResponseBody
	public void insert() {
		SpecInfo specinfo = new SpecInfo();
		specinfo.setSpeccode("test");
		specinfo.setSpecname("测试2019-12-12");
		specinfo.setCategorate("国家标准");
		String id = iSearchClient.insert(INDEX, TYPE, specinfo);
		System.out.println(id);
	}
	
	@RequestMapping(name = "/delete")
	@ResponseBody
	public void delete(@RequestParam("id") String id) {
		String result = iSearchClient.deleteDoc(INDEX, TYPE,id);
		System.out.println(result);
	}
	
	
}
