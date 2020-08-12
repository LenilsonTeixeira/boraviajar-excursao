package br.com.boraviajar.apifinder.service;

import br.com.boraviajar.apifinder.controller.model.SearchRequestParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Objects;

@UtilityClass
public class QueryRequestBuilder {

    public static QueryBuilder build(final SearchRequestParam searchRequestParam){
        final BoolQueryBuilder query = QueryBuilders.boolQuery();

        if(validateStringParam(searchRequestParam.getDepartureCity())){
            query.must(QueryBuilders.queryStringQuery(searchRequestParam.getDepartureCity())
                    .field("cidadeOrigem")
                    .defaultOperator(Operator.AND));
        }

        if(validateStringParam(searchRequestParam.getDestination())){
            query.must(QueryBuilders.matchQuery("destino", searchRequestParam.getDestination())
                    .operator(Operator.AND));
        }

        if(validateStringParam(searchRequestParam.getAgency())){
            query.must(QueryBuilders.matchQuery("agencia", searchRequestParam.getAgency())
                    .operator(Operator.AND));
        }

        if(validateSingleDateParam(searchRequestParam.getDepartureDate())){
            query.must(QueryBuilders.matchQuery("dataPartida", searchRequestParam.getDepartureDate())
                    .operator(Operator.AND));
        }

        if(validateMultiDateParam(searchRequestParam.getStartDate(), searchRequestParam.getEndDate())){
            query.must(QueryBuilders.rangeQuery("dataPartida")
                    .gte(searchRequestParam.getStartDate())
                    .lte(searchRequestParam.getEndDate()));
        }

        return query;

    }

    private boolean validateStringParam(final String param){
        return !StringUtils.isEmpty(param);
    }

    private boolean validateSingleDateParam(final LocalDate dateParam){
        return Objects.nonNull(dateParam);
    }

    private boolean validateMultiDateParam(final LocalDate startDate, final LocalDate endDate){
        return Objects.nonNull(startDate) && Objects.nonNull(endDate);
    }
}
