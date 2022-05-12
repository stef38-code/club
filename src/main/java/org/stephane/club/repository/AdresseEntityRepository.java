package org.stephane.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.club.entities.AdresseEntity;
@Repository
public interface AdresseEntityRepository extends JpaRepository<AdresseEntity, String> {
}
