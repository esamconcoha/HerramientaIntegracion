package com.react.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_conversacion",schema = "react",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario","id_conversacion"})})
@Getter
@Setter
@IdClass(UsuarioConversacionPk.class)
public class UsuarioConversacion {
    @Id
    @Column(name = "usuario")
    private String usuario;

    @Id
    @Column(name = "id_conversacion")
    private Long idConversacion;

    @Column(name = "correo_usuario")
    private String correoUsuario;


}
