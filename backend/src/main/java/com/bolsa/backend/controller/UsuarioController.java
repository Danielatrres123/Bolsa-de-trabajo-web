package com.bolsa.backend.controller;

import com.bolsa.backend.model.Usuario;
import com.bolsa.backend.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioRepository repo;
    public UsuarioController(UsuarioRepository repo){ this.repo = repo; }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario u){
        if(u.getEmail()==null || u.getPassword()==null) return ResponseEntity.badRequest().build();
        if(repo.findByEmail(u.getEmail()).isPresent()) return ResponseEntity.badRequest().build();
        Usuario saved = repo.save(u);
        return ResponseEntity.created(URI.create("/api/usuarios/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
