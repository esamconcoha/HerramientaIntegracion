package com.example.documentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos")
@NoArgsConstructor
@AllArgsConstructor
public class Documentos {
    @Id
    @Column(name = "id_documento")
    private Long idDocumento;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "id_usuario")
    private Long idUsuario;

    public Long getIdDocumento() {
        return this.idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return this.nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
