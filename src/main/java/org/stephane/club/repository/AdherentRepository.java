package org.stephane.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.club.entities.AdherentEntity;

import java.util.UUID;
@Repository
public interface AdherentRepository extends JpaRepository<AdherentEntity, UUID> {

}
