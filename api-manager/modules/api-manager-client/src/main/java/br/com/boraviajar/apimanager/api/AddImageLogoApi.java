package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.addimagelogo.AddImageLogoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

public interface AddImageLogoApi {

    @PostMapping("fotos/logo")
    @ResponseStatus(value = HttpStatus.OK)
    AddImageLogoResponse upload(@RequestHeader("agency_id") final String agencyId, @RequestParam("logo") final MultipartFile logo);

}
