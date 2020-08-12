package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;

public interface AddAgencyGateway {

    AddedAgencyDomain add(final AddAgencyDomain addAgencyDomain);

}
