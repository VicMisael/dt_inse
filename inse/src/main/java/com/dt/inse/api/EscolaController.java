package com.dt.inse.api;

import com.dt.inse.application.service.IEscolaService;
import com.dt.inse.domain.model.Escola;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("escola")
public class EscolaController {

    final IEscolaService escolaService;

    public EscolaController(IEscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping("{id}")
    public Escola getEscolaById(@PathVariable
                                Long id) {
        return escolaService.getEscolaById(id);

    }
}
