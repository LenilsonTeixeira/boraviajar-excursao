package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.UpdateTravelApi;
import br.com.boraviajar.apimanager.controller.translator.UpdateTravelRequestToUpdateTravelDomainTranslator;
import br.com.boraviajar.apimanager.controller.translator.UpdatedTravelDomainToUpdateTravelResponseTranslator;
import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelRequest;
import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelResponse;
import br.com.boraviajar.apimanager.usecase.UpdateTravelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UpdateTravelController implements UpdateTravelApi {

    @Autowired
    private UpdateTravelUseCase updateTravelUseCase;

    @Override
    public UpdateTravelResponse update(final @RequestHeader("agency_id") String agencyId, final @PathVariable("id") String id, final @Valid @RequestBody UpdateTravelRequest updateTravelRequest) {

        final UpdateTravelDomain updateTravelDomain = UpdateTravelRequestToUpdateTravelDomainTranslator.translate(id, agencyId, updateTravelRequest);

        return UpdatedTravelDomainToUpdateTravelResponseTranslator.translate(updateTravelUseCase.execute(updateTravelDomain));

    }
}
