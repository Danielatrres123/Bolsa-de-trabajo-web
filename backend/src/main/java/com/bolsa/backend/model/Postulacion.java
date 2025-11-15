package com.bolsa.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("applications")
public class Postulacion {
    @Id
    private String id;
    private String ofertaId;
    private String postulanteId;
    private LocalDateTime fecha;
    private String cvUrl;
    private String estado; // EN_REVISION, ACEPTADO, RECHAZADO
}
