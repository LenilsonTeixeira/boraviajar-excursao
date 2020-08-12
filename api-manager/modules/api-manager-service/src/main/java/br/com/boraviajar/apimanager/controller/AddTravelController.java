package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.AddTravelApi;
import br.com.boraviajar.apimanager.controller.translator.AddedTravelDomainToTravelResponseTranslator;
import br.com.boraviajar.apimanager.controller.translator.TravelRequestToAddTravelDomainTranslator;
import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.model.addtravel.TravelRequest;
import br.com.boraviajar.apimanager.model.addtravel.TravelResponse;
import br.com.boraviajar.apimanager.usecase.AddTravelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddTravelController implements AddTravelApi {

    @Autowired
    private AddTravelUseCase addTravelUseCase;

    @Override
    public TravelResponse add(@RequestHeader("agency_id") final String agency, @Valid @RequestBody final TravelRequest travelRequest) {

        final AddTravelDomain addTravelDomain = TravelRequestToAddTravelDomainTranslator.translate(agency, travelRequest);

        return AddedTravelDomainToTravelResponseTranslator.translate(addTravelUseCase.execute(addTravelDomain));
    }
}
