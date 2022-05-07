package org.stephane.club.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.share.defaut.service.DefaultService;

public interface AdherentService<T, D, R extends JpaRepository> extends DefaultService<T,D,R> {

}
