package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.DeleteAgencyApi;
import br.com.boraviajar.apimanager.usecase.DeleteAgencyUseCase;
import br.com.boraviajar.apimanager.usecase.validator.AgencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAgencyController implements DeleteAgencyApi {

    @Autowired
    private DeleteAgencyUseCase deleteAgencyUseCase;

    @Override
    public void delete(@RequestHeader("agency_id") final String agencyId, @PathVariable("id") final String id) {

        AgencyValidator.isEquals(agencyId, id);

        deleteAgencyUseCase.execute(id);
    }
}
