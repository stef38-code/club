package org.stephane.club.adherent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.club.adherent.entities.AdherentEntity;

import java.util.UUID;
@Repository
public interface AdherentRepository extends JpaRepository<AdherentEntity, UUID> {

}
