package br.com.boraviajar.apimanager.gateway.database.repository;

import br.com.boraviajar.apimanager.gateway.database.entity.imagelogo.ImageLogoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageLogoRepository extends MongoRepository<ImageLogoEntity, String> {

}
