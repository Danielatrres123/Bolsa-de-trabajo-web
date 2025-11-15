package com.bolsa.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String password;
    private String rol; // POSTULANTE, EMPRESA, ADMIN
}
