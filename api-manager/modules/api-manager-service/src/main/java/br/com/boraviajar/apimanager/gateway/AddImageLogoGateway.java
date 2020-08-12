package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.domain.imagelogo.AddImageLogoDomain;
import br.com.boraviajar.apimanager.domain.imagelogo.AddedImageLogoDomain;

public interface AddImageLogoGateway {

    AddedImageLogoDomain add(final AddImageLogoDomain addImageLogoDomain);

}
