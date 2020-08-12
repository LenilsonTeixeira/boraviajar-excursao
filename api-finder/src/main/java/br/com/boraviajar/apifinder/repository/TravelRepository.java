package br.com.boraviajar.apifinder.repository;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;

public interface TravelRepository {
    SearchResponse searchBy(SearchRequest searchRequest) throws IOException;
}
