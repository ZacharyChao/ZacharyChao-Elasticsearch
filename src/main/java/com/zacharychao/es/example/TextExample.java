package com.zacharychao.es.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zacharychao.es.entity.SpecInfo;

public class TextExample {
//	private static final String HOST = "39.100.232.215";
	private static final String HOST = "192.168.183.131";
//	public static void main(String[] args) throws UnknownHostException {
//		Settings settings = Settings.builder().put("cluster.name","docker-cluster").build();
//		TransportClient client = new PreBuiltTransportClient(settings);
//		client.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.232.215"),9300));
//		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//		MatchPhraseQueryBuilder nameMatchPhraseQuery = QueryBuilders.matchPhraseQuery("specname", "≤‚ ‘2019-12-12");
//		boolQuery.must(nameMatchPhraseQuery);
//		SearchRequestBuilder builder = client.prepareSearch("specinfo").setTypes("doc").setQuery(boolQuery);
//		SearchHits hits = builder.get().getHits();
//		List<String> list = new ArrayList<String>();
//		hits.forEach(item -> list.add(item.getId()));
//		System.out.println(list);
//		
//		for(String id : list) {
//			String result = client.prepareDelete("specinfo", "doc", id).get().getId();
//			System.out.println(result);
//		}
//		client.close();
//	}
	
	private static TransportClient client = null;
	public static void init() throws UnknownHostException {
		Settings settings = Settings.builder().put("cluster.name","docker-cluster").build();
		client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(InetAddress.getByName(HOST),9300));
		
	}
	
	public static void close() {
		client.close();
	}
	
	public static List<SpecInfo> search() throws Exception{
		init();
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		MatchPhraseQueryBuilder phraseQuery = QueryBuilders.matchPhraseQuery("specname", "≤‚ ‘2019-12-12");
		boolQuery.must(phraseQuery);
		SearchResponse searchResponse = client.prepareSearch("specinfo").setTypes("doc").setQuery(boolQuery).get();
		SearchHits hits = searchResponse.getHits();
		List<SpecInfo> list = new ArrayList<SpecInfo>();
		hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString(), SpecInfo.class)));
		
		close();
		return list;
	}
	
	public static List<String> searchIdList() throws UnknownHostException{
		init();
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		MatchPhraseQueryBuilder matchPhraseQuery = QueryBuilders.matchPhraseQuery("specname", "≤‚ ‘2019-12-12");
		boolQuery.must(matchPhraseQuery);
		List<String> list = new ArrayList<String>();
		SearchRequestBuilder builder = client.prepareSearch("specinfo").setTypes("doc").setQuery(boolQuery);
		SearchHits hits = builder.get().getHits();
		hits.forEach(item -> list.add(item.getId()));
		close();
		System.out.println("idList ******* " + list);
		return list;
	}
	
	public static void insert() throws JsonProcessingException, UnknownHostException {
		init();
		SpecInfo info = new SpecInfo();
		info.setSpecname("≤‚ ‘2019-12-12");
		info.setState("test");
		ObjectMapper mapper = new ObjectMapper();
		String source = mapper.writeValueAsString(info);
		IndexResponse response = client.prepareIndex("specinfo", "doc").setSource(source, XContentType.JSON).get();
		if(response != null) {
			System.out.println(response.getId());
		}
		close();
	}
	
	public static List<String> delete(List<String> searchIds) throws Exception{
		init();
		List<String> list = new ArrayList<>();
		for(String id : searchIds) {
			String result = client.prepareDelete("specinfo", "doc", id).get().getId();
			list.add(result);
		}
		close();
		return list;
	}
	
	public static void update() throws Exception {
		init();
		SpecInfo info = new SpecInfo();
		info.setRevision("revision");
		UpdateRequest request = new UpdateRequest();
		request.index("specinfo").type("doc").id("Fh4-_W4BPATBNYEr7MWJ").doc(JSON.toJSONString(info),XContentType.JSON);
		UpdateResponse response = client.update(request).get();
		System.out.println(response.getId());
		close();
	}
	
	public static void main(String[] args) {
		try {
//			insert();
//			System.out.println(searchIdList());
//			List<String> list = new ArrayList<String>();
//			list = searchIdList();
//			System.out.println(delete(list));
//			update();
			System.out.println(search());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
