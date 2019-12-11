package com.zacharychao.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<String> list = iSearchClient.searchString(INDEX, TYPE, "specname", "化肥催化剂产品分类、型号和命名");
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
		List<SpecInfo> list = iSearchClient.search(INDEX, TYPE, "categoryid", "7af11140-04f9-11e8-9e05-00155d051606",SpecInfo.class);
		return list;
	}
	
	
}
