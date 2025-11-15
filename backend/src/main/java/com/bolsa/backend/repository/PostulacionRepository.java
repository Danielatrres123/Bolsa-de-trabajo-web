package com.bolsa.backend.repository;

import com.bolsa.backend.model.Postulacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostulacionRepository extends MongoRepository<Postulacion, String> {
    List<Postulacion> findByOfertaId(String ofertaId);
    List<Postulacion> findByPostulanteId(String postulanteId);
}
