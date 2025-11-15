package com.bolsa.backend.controller;

import com.bolsa.backend.model.Postulacion;
import com.bolsa.backend.repository.PostulacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {
    private final PostulacionRepository repo;
    public PostulacionController(PostulacionRepository repo){ this.repo = repo; }

    @PostMapping
    public ResponseEntity<Postulacion> create(@RequestBody Postulacion p){
        p.setFecha(LocalDateTime.now());
        if(p.getEstado() == null) p.setEstado("EN_REVISION");
        Postulacion saved = repo.save(p);
        return ResponseEntity.created(URI.create("/api/postulaciones/" + saved.getId())).body(saved);
    }

    @GetMapping("/oferta/{offerId}")
    public List<Postulacion> byOffer(@PathVariable String offerId){
        return repo.findByOfertaId(offerId);
    }

    @GetMapping("/usuario/{userId}")
    public List<Postulacion> byUser(@PathVariable String userId){
        return repo.findByPostulanteId(userId);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Postulacion> updateStatus(@PathVariable String id, @RequestParam String estado){
        return repo.findById(id).map(app -> {
            app.setEstado(estado);
            repo.save(app);
            return ResponseEntity.ok(app);
        }).orElse(ResponseEntity.notFound().build());
    }
}
