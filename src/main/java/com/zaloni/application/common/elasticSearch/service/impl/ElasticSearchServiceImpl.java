package com.zaloni.application.common.elasticSearch.service.impl;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaloni.application.common.elasticSearch.service.IElasticSearchService;

@Service
public class ElasticSearchServiceImpl implements IElasticSearchService {

	@Autowired
	private ElasticsearchTemplate elasticSearchTemplate;
	
	@Autowired
	public ObjectMapper objectMapper;

	@Override
	public void createIndex(String index) {

		if (!elasticSearchTemplate.indexExists(index)) {
			elasticSearchTemplate.createIndex(index);
		}

	}

	@Override
	@Async("processExecutor")
	public void addDocument(String index, String type, String id, Object obj, Class mappedClass) {
        
		IndexQuery indexQuery = new IndexQueryBuilder().withId(id).withIndexName(index).withObject(obj)
				.withType(type).build();

		elasticSearchTemplate.putMapping(mappedClass);
		elasticSearchTemplate.index(indexQuery);
		elasticSearchTemplate.refresh(mappedClass);

	}

	@Override
	@Async("processExecutor")
	public void updateDocument(String index, String type, String id, Object obj, Class mappedClass) {

		UpdateQuery query = new UpdateQuery();
		
		query.setId(String.valueOf(id));
		query.setIndexName(index);
		query.setType(type);

		IndexRequest indexRequest = new IndexRequest(index, type, id);
		
		try {
			indexRequest.source(objectMapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateRequest updateRequest = new UpdateRequest(index, type, id);
		

		updateRequest.doc(indexRequest);
		query.setUpdateRequest(updateRequest);

		elasticSearchTemplate.update(query);

	}

}
