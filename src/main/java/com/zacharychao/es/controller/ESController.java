package com.zacharychao.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
