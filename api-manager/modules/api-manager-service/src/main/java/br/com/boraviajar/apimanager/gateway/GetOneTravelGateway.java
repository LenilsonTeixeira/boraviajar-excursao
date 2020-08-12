package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.SearchOneTravelDomain;

import java.util.Optional;

public interface GetOneTravelGateway {

    Optional<ObtainedTravelDomain> get(final String id);

}
