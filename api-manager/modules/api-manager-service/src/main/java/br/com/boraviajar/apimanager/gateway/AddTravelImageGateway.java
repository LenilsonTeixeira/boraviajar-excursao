package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.travelimage.AddTravelImageDomain;
import br.com.boraviajar.apimanager.domain.travelimage.AddedTravelImageDomain;

public interface AddTravelImageGateway {

    AddedTravelImageDomain upload(final AddTravelImageDomain addTravelImageDomain);

}
