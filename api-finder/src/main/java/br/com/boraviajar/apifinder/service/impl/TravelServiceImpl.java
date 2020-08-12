package br.com.boraviajar.apifinder.service.impl;

import br.com.boraviajar.apifinder.controller.model.SearchRequestParam;
import br.com.boraviajar.apifinder.document.Travel;
import br.com.boraviajar.apifinder.exception.SearchResultException;
import br.com.boraviajar.apifinder.repository.TravelRepository;
import br.com.boraviajar.apifinder.service.QueryRequestBuilder;
import br.com.boraviajar.apifinder.service.TravelService;
import br.com.boraviajar.apifinder.service.model.TravelData;
import br.com.boraviajar.apifinder.service.translator.SearchHitToTravelTranslator;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Value("${elasticsearch.index}")
    private String index;

    @Value("${elasticsearch.search.scrollTimeValue}")
    private Long scrollTimeValue;

    @Value(("${elasticsearch.search.size}"))
    private Integer searchSize;

    private QueryBuilder buildQuery(final SearchRequestParam searchRequestParam) {
        return QueryRequestBuilder.build(searchRequestParam);
    }

    private SearchSourceBuilder buildSearchSourceBuilder(QueryBuilder matchQueryBuilder) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.sort("dataPartida", SortOrder.ASC);
        searchSourceBuilder.size(searchSize);
        return searchSourceBuilder;
    }

    private SearchRequest buildSearchRequest(SearchSourceBuilder searchSourceBuilder) {
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(scrollTimeValue));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.scroll(scroll);
        searchRequest.indices(index).indicesOptions(IndicesOptions.STRICT_EXPAND_OPEN);
        searchRequest.source(searchSourceBuilder);
        return searchRequest;
    }

    private TravelData buildResponseData(SearchResponse response, List<Travel> travels) {
        return TravelData.builder()
                .elements(travels)
                .scrollId(response.getScrollId())
                .totalElements(getTotalElements(response))
                .build();
    }

    private List<Travel> getTravels(SearchResponse response) {
        return Arrays.stream(response.getHits().getHits())
                .map(SearchHitToTravelTranslator::translate)
                .collect(Collectors.toList());
    }

    private Long getTotalElements(final SearchResponse searchResponse) {
        return searchResponse.getHits().getTotalHits().value;
    }

    @Override
    public TravelData searchBy(final SearchRequestParam searchRequestParam) {

        try {

            QueryBuilder matchQueryBuilder = buildQuery(searchRequestParam);

            SearchSourceBuilder searchSourceBuilder = buildSearchSourceBuilder(matchQueryBuilder);

            SearchRequest searchRequest = buildSearchRequest(searchSourceBuilder);

            SearchResponse response = travelRepository.searchBy(searchRequest);

            final List<Travel> travels = getTravels(response);

            return buildResponseData(response, travels);

        } catch (final Exception e) {
            log.error("Falha durante processamento da query.");
            throw new SearchResultException("Falha durante processamento da query.", e);
        }
    }
}
