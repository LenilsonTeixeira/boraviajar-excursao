package br.com.boraviajar.apifinder.service;

import br.com.boraviajar.apifinder.controller.model.SearchRequestParam;
import br.com.boraviajar.apifinder.service.model.TravelData;

public interface TravelService {

    TravelData searchBy(final SearchRequestParam searchRequestParam);
}
