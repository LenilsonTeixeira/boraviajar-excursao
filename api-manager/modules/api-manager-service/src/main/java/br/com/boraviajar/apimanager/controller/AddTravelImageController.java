package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.AddTravelImageApi;
import br.com.boraviajar.apimanager.usecase.AddTravelImageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class AddTravelImageController implements AddTravelImageApi {

    @Autowired
    private AddTravelImageUseCase addTravelImageUseCase;

    @Override
    public void upload(String travelId, MultipartFile[] files) {

        addTravelImageUseCase.execute(travelId, files);

    }
}
