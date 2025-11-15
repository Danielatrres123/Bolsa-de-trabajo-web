package com.bolsa.backend.controller;

import com.bolsa.backend.model.Empresa;
import com.bolsa.backend.repository.EmpresaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    private final EmpresaRepository repo;
    public EmpresaController(EmpresaRepository repo){ this.repo = repo; }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa e){
        Empresa saved = repo.save(e);
        return ResponseEntity.created(URI.create("/api/empresas/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
