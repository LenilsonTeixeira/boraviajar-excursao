package br.com.boraviajar.apifinder.repository.impl;

import br.com.boraviajar.apifinder.repository.TravelRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class TravelRepositoryImpl implements TravelRepository {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public SearchResponse searchBy(final SearchRequest searchRequest) throws IOException {
        return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }
}
