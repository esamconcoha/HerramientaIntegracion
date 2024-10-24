package com.react.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios", schema = "react")
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @Column(name = "correo")
    private String correo;

    @Column(name = "no_telefono")
    private Long noTelefono;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "usuario_creo")
    private String usuarioCreo;

    @Column(name = "fecha_creo")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private java.sql.Date fechaCreo;

    @Column(name= "dpi", nullable = false,unique = true)
    private String dpi;

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getNoTelefono() {
        return this.noTelefono;
    }

    public void setNoTelefono(Long noTelefono) {
        this.noTelefono = noTelefono;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuarioCreo() {
        return this.usuarioCreo;
    }

    public void setUsuarioCreo(String usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
    }

    public java.sql.Date getFechaCreo() {
        return this.fechaCreo;
    }

    public void setFechaCreo(java.sql.Date fechaCreo) {
        this.fechaCreo = fechaCreo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
}
