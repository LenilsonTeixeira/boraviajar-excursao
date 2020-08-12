package br.com.boraviajar.apifinder.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private Integer port;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient elasticsearchClient() {
        return new RestHighLevelClient(restClientBuilder());
    }

    private RestClientBuilder restClientBuilder() {
        return RestClient.builder(new HttpHost(this.host, this.port));
    }

}
