package com.bolsa.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("companies")
public class Empresa {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String contactoEmail;
    private String usuarioId;
}
