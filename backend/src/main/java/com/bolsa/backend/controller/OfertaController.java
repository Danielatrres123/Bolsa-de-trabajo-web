package com.bolsa.backend.controller;

import com.bolsa.backend.model.Oferta;
import com.bolsa.backend.repository.OfertaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaController {
    private final OfertaRepository repo;
    public OfertaController(OfertaRepository repo){ this.repo = repo; }

    @PostMapping
    public ResponseEntity<Oferta> create(@RequestBody Oferta o){
        o.setFechaPublicacion(LocalDateTime.now());
        Oferta saved = repo.save(o);
        return ResponseEntity.created(URI.create("/api/ofertas/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Oferta> list(@RequestParam(required = false) String ubicacion){
        if(ubicacion != null && !ubicacion.isBlank()) return repo.findByUbicacionContainingIgnoreCase(ubicacion);
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
