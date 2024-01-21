package com.dt.inse.api;

import com.dt.inse.application.service.IEscolaService;
import com.dt.inse.domain.model.Escola;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escola")
@CrossOrigin(origins = "http://localhost:3000")
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
