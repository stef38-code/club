package org.stephane.club.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.GouvApiCommuneDto;
import org.stephane.club.entities.GouvApiCommune;
import org.stephane.club.repository.GouvApiCommuneRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

@Service
@Slf4j
public class GouvApiCommuneServiceImpl extends DefaultServiceImpl<GouvApiCommune, GouvApiCommuneDto, GouvApiCommuneRepository> implements GouvApiCommuneService<GouvApiCommune, GouvApiCommuneDto> {
    public GouvApiCommuneServiceImpl(GouvApiCommuneRepository repository) {
        super(repository, TypeServiceMapperDto.GOUVAPICOMMUNE);
    }
}
