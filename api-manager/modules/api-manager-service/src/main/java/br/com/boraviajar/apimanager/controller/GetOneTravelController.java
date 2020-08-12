package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.GetOneTravelApi;
import br.com.boraviajar.apimanager.controller.translator.ObtainedTravelDomainToGetOneTravelResponseTranslator;
import br.com.boraviajar.apimanager.model.getonetravel.GetOneTravelResponse;
import br.com.boraviajar.apimanager.usecase.GetOneTravelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOneTravelController implements GetOneTravelApi {

    @Autowired
    private GetOneTravelUseCase getOneTravelUseCase;

    @Override
    public GetOneTravelResponse get(final @RequestHeader("agency_id") String agencyId, final @PathVariable("id") String id) {

        return ObtainedTravelDomainToGetOneTravelResponseTranslator.translate(getOneTravelUseCase.execute(id));

    }
}
