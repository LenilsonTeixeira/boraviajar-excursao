package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.AddAgencyApi;
import br.com.boraviajar.apimanager.controller.translator.AddedAgencyDomainToAgencyResponseTranslator;
import br.com.boraviajar.apimanager.controller.translator.AgencyRequestToAddAgencyDomainTranslator;
import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.model.addagency.AgencyRequest;
import br.com.boraviajar.apimanager.model.addagency.AgencyResponse;
import br.com.boraviajar.apimanager.usecase.AddAgencyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddAgencyController implements AddAgencyApi {

    @Autowired
    private AddAgencyUseCase addAgencyUseCase;

    @Override
    public AgencyResponse add(@Valid @RequestBody final AgencyRequest agencyRequest) {

        final AddAgencyDomain addAgencyDomain = AgencyRequestToAddAgencyDomainTranslator.translate(agencyRequest);

        return AddedAgencyDomainToAgencyResponseTranslator.translate(addAgencyUseCase.execute(addAgencyDomain));
    }
}
