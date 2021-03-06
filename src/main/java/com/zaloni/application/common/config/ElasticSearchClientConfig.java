package com.zaloni.application.common.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
public class ElasticSearchClientConfig {
	
	   @Value("${elasticsearch.host}")
	    private String EsHost;

	    @Value("${elasticsearch.port}")
	    private int EsPort;

	    @Value("${elasticsearch.clustername}")
	    private String EsClusterName;

	    @Bean
	    public Client client() throws Exception {

	        Settings esSettings = Settings.settingsBuilder()
	                .put("cluster.name", EsClusterName)
	                .build();

	        
	        return TransportClient.builder()
	                .settings(esSettings)
	                .build()
	                .addTransportAddress(
					  new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
	    }

	    @Bean
	    
	    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
	        return new ElasticsearchTemplate(client());
	    }
   
}
