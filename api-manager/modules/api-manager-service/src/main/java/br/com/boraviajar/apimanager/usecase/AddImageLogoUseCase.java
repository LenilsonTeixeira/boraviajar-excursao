package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.imagelogo.AddImageLogoDomain;
import br.com.boraviajar.apimanager.domain.imagelogo.AddedImageLogoDomain;
import br.com.boraviajar.apimanager.exception.AddImageLogoException;
import br.com.boraviajar.apimanager.gateway.AddImageLogoGateway;
import br.com.boraviajar.apimanager.usecase.rule.Rule;
import br.com.boraviajar.apimanager.usecase.rule.PreCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
public class AddImageLogoUseCase {

    @Autowired
    private UploadLocalImageLogoUseCase uploadLocalImageLogoUseCase;

    @Autowired
    private PreCondition preCondition;

    @Autowired
    private AddImageLogoGateway addImageLogoGateway;

    public AddedImageLogoDomain execute(final String agencyId, final MultipartFile file){

        for(final Rule<String> preCondition: this.preCondition.get()) {

            preCondition.validate(agencyId);

        }

        try{

            final AddImageLogoDomain addImageLogoDomain = uploadLocalImageLogoUseCase.execute(agencyId, file);

            return addImageLogoGateway.add(addImageLogoDomain);

        } catch (final Exception e){

            log.error("Falha ao realizar upload de imagem.: %s", file.getOriginalFilename());

            throw new AddImageLogoException(String.format("Falha durante upload de imagem: %s.", e));
        }
    }
}
