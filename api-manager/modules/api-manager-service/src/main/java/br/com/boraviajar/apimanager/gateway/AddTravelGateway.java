package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;

public interface AddTravelGateway {

    AddedTravelDomain add(final AddTravelDomain addTravelDomain);

}
