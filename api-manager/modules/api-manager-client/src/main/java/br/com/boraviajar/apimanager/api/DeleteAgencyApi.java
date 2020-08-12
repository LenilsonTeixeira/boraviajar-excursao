package br.com.boraviajar.apimanager.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface DeleteAgencyApi {

    @DeleteMapping("agencias/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void delete(@RequestHeader("agency_id") final String agencyId,
                @PathVariable("id") final String id);
}
