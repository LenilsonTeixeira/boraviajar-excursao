package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;

public interface UpdateTravelGateway {

    UpdatedTravelDomain update(final UpdateTravelDomain updateTravelDomain);

}
