package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.DeleteTravelApi;
import br.com.boraviajar.apimanager.usecase.DeleteTravelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTravelController implements DeleteTravelApi {

    @Autowired
    private DeleteTravelUseCase deleteTravelUseCase;

    @Override
    public void delete(final @RequestHeader("agency_id") String agencyId, @PathVariable("id") final String id) {

        deleteTravelUseCase.execute(id);

    }
}
