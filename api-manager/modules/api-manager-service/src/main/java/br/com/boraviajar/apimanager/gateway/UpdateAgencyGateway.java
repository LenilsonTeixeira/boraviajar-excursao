package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.UpdatedAgencyDomain;

public interface UpdateAgencyGateway {

    UpdatedAgencyDomain update(final UpdateAgencyDomain updateAgencyDomain);

}
