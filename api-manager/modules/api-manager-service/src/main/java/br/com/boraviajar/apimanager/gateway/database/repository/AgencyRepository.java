package br.com.boraviajar.apimanager.gateway.database.repository;

import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends MongoRepository<AgencyEntity, String> {

    @Override
    boolean existsById(String id);

}
