package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.GetOneAgencyApi;
import br.com.boraviajar.apimanager.controller.translator.ObtainedAgencyDomainToGetAgencyResponseTranslator;
import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.model.getoneagency.GetAgencyResponse;
import br.com.boraviajar.apimanager.usecase.GetAgencyUseCase;
import br.com.boraviajar.apimanager.usecase.validator.AgencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOneAgencyController implements GetOneAgencyApi {

    @Autowired
    private GetAgencyUseCase getAgencyUseCase;

    @Override
    public GetAgencyResponse get(@RequestHeader("agency_id") final String agencyId, @PathVariable("id")  final String id) {

        AgencyValidator.isEquals(agencyId, id);

        final ObtainedAgencyDomain obtainedAgencyDomain = getAgencyUseCase.execute(id);

        return ObtainedAgencyDomainToGetAgencyResponseTranslator.translate(obtainedAgencyDomain);
    }
}
