package com.zaloni.application.common.elasticSearch.service;

public interface IElasticSearchService {

	public void createIndex(String index);
	public void addDocument(String index, String type,String id,Object obj, Class mappedClass);
	public void updateDocument(String index, String type, String id,Object obj, Class mappedClass);
}
