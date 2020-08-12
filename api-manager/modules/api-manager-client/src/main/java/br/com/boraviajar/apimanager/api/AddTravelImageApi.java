package br.com.boraviajar.apimanager.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

public interface AddTravelImageApi {

    @PostMapping("fotos")
    @ResponseStatus(value = HttpStatus.OK)
    void upload(@RequestHeader("travel_id") final String travelId,  @RequestParam("fotos") final MultipartFile[] files);

}
