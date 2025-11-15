package com.bolsa.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("offers")
public class Oferta {
    @Id
    private String id;
    private String empresaId;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String tipoContrato;
    private String salario;
    private LocalDateTime fechaPublicacion;
    private boolean activo = true;
}
