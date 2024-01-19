package com.dt.inse.application.service.impl;

import com.dt.inse.application.service.IEscolaService;
import com.dt.inse.domain.model.Escola;
import com.dt.inse.infrastructure.JpaEntities.mappers.InseJpaToEscolaDomain;
import com.dt.inse.infrastructure.JpaEntities.repository.InseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService implements IEscolaService {

    final InseRepository inseRepository;

    public EscolaService(InseRepository inseRepository) {
        this.inseRepository = inseRepository;
    }

    @Override
    public Escola getEscolaById(Long schoolid) {
        if (inseRepository.existsByIdEscola(schoolid)) {
            return InseJpaToEscolaDomain.mapToInse(inseRepository.findByIdEscola(schoolid));
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "school not found"
        );
    }
}
