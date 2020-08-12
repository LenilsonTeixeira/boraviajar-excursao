package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;

import java.util.Optional;

public interface GetOneAgencyGateway {

    Optional<ObtainedAgencyDomain> get(final String id);

}
