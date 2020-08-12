package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.imagelogo.AddImageLogoDomain;
import br.com.boraviajar.apimanager.domain.imagelogo.AddedImageLogoDomain;
import br.com.boraviajar.apimanager.gateway.AddImageLogoGateway;
import br.com.boraviajar.apimanager.gateway.database.entity.imagelogo.ImageLogoEntity;
import br.com.boraviajar.apimanager.gateway.database.repository.ImageLogoRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.AddImageLogoDomainToImageLogoEntityTranslator;
import br.com.boraviajar.apimanager.gateway.database.translator.ImageLogoEntityToAddedImageLogoDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addImageLogoGatewayImpl")
public class AddImageLogoGatewayImpl implements AddImageLogoGateway {

    @Autowired
    private ImageLogoRepository imageLogoRepository;

    @Override
    public AddedImageLogoDomain add(AddImageLogoDomain addImageLogoDomain) {

        final ImageLogoEntity imageLogoEntity = AddImageLogoDomainToImageLogoEntityTranslator.translate(addImageLogoDomain);

        imageLogoEntity.generateId();

        return ImageLogoEntityToAddedImageLogoDomainTranslator.translate(imageLogoRepository.save(imageLogoEntity));

    }
}
