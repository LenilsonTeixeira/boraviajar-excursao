package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.getoneagency.GetAgencyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface GetOneAgencyApi {

    @GetMapping("agencias/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    GetAgencyResponse get(@RequestHeader("agency_id") final String agencyId,
                          @PathVariable("id") final String id);
}
