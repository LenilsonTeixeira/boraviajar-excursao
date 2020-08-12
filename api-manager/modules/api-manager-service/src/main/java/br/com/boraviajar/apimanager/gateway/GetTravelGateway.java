package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.travel.RetrievedTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.SearchTravelDomain;
import org.springframework.data.domain.Page;

public interface GetTravelGateway {

    Page<RetrievedTravelDomain> get(final SearchTravelDomain searchTravelDomain);

}
