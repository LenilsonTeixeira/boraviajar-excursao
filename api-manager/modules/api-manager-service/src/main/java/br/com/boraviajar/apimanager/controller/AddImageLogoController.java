package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.AddImageLogoApi;
import br.com.boraviajar.apimanager.controller.translator.AddedImageLogoDomainToAddImageLogoResponseTranslator;
import br.com.boraviajar.apimanager.model.addimagelogo.AddImageLogoResponse;
import br.com.boraviajar.apimanager.usecase.AddImageLogoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AddImageLogoController implements AddImageLogoApi {

    @Autowired
    private AddImageLogoUseCase addImageLogoUseCase;

    @Override
    public AddImageLogoResponse upload(String agencyId, MultipartFile logo) {

        return AddedImageLogoDomainToAddImageLogoResponseTranslator.translate(addImageLogoUseCase.execute(agencyId, logo));
        
    }
}
