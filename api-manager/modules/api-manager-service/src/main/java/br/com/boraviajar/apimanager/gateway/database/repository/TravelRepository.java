package br.com.boraviajar.apimanager.gateway.database.repository;

import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends MongoRepository<TravelEntity, String> {

    Page<TravelEntity> findByAgencyId(final String agencyId, final Pageable pageable);

}
