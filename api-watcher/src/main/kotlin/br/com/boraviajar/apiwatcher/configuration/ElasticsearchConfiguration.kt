package br.com.boraviajar.apiwatcher.configuration

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestClientBuilder
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ElasticsearchConfiguration {

    @Value("\${elasticsearch.host}")
    private val host: String? = null

    @Value("\${elasticsearch.port}")
    private val port: Int? = null

    @Bean(destroyMethod = "close")
    fun restHighLevelClient(): RestHighLevelClient? {
        return RestHighLevelClient(restClientBuilder())
    }

    private fun restClientBuilder(): RestClientBuilder? {
        return RestClient.builder(HttpHost(host, port!!))
    }
}