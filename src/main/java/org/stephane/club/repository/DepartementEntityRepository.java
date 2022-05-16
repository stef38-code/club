package org.stephane.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.club.entities.DepartementEntity;

@Repository
public interface DepartementEntityRepository extends JpaRepository<DepartementEntity, String> {
}
