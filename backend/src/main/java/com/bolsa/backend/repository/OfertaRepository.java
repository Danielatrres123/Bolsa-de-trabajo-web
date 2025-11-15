package com.bolsa.backend.repository;

import com.bolsa.backend.model.Oferta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OfertaRepository extends MongoRepository<Oferta, String> {
    List<Oferta> findByEmpresaId(String empresaId);
    List<Oferta> findByUbicacionContainingIgnoreCase(String ubicacion);
}
