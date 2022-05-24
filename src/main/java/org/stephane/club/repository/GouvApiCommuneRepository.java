package org.stephane.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.club.entities.CommuneApiGouvEntity;

import java.util.List;

@Repository
public interface GouvApiCommuneRepository extends JpaRepository<CommuneApiGouvEntity, String> {
    List<CommuneApiGouvEntity> findByCodePostal(String codePostal);

}
