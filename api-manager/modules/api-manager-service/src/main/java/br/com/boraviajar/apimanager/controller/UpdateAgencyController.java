package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.UpdateAgencyApi;
import br.com.boraviajar.apimanager.controller.translator.AgencyRequestToUpdateAgencyDomainTranslator;
import br.com.boraviajar.apimanager.controller.translator.UpdatedAgencyDomainToAgencyResponseTranslator;
import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyRequest;
import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyResponse;
import br.com.boraviajar.apimanager.usecase.UpdateAgencyUseCase;
import br.com.boraviajar.apimanager.usecase.validator.AgencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UpdateAgencyController implements UpdateAgencyApi {

    @Autowired
    private UpdateAgencyUseCase updateAgencyUseCase;

    @Override
    public UpdateAgencyResponse update(final @RequestHeader("agency_id") String agencyId, @PathVariable("id") final String id, final @Valid @RequestBody UpdateAgencyRequest updateAgencyRequest) {

        AgencyValidator.isEquals(agencyId, id);

        final UpdateAgencyDomain updateAgencyDomain = AgencyRequestToUpdateAgencyDomainTranslator.translate(id, updateAgencyRequest);

        return UpdatedAgencyDomainToAgencyResponseTranslator.translate(updateAgencyUseCase.execute(updateAgencyDomain));
    }
}
