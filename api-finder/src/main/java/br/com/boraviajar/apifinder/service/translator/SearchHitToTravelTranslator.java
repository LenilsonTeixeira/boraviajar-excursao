package br.com.boraviajar.apifinder.service.translator;

import br.com.boraviajar.apifinder.document.Travel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Component;

@Component
public class SearchHitToTravelTranslator {

    SearchHitToTravelTranslator(final ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    private static ObjectMapper objectMapper;

    public static Travel translate(final SearchHit documentFields){
        return objectMapper.convertValue(documentFields.getSourceAsMap(), Travel.class);
    }
}
