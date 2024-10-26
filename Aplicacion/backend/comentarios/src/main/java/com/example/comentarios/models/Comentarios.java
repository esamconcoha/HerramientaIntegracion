package com.example.comentarios.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
public class Comentarios {
    @Id
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @Column(name = "desc_comentario")
    private String descComentario;

    @Column(name = "fecha_comentario")
    private java.sql.Date fechaComentario;

    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(name = "id_usuario_ingreso")
    private Long idUsuarioIngreso;

    public Long getIdComentario() {
        return this.idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getDescComentario() {
        return this.descComentario;
    }

    public void setDescComentario(String descComentario) {
        this.descComentario = descComentario;
    }

    public java.sql.Date getFechaComentario() {
        return this.fechaComentario;
    }

    public void setFechaComentario(java.sql.Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Long getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdUsuarioIngreso() {
        return this.idUsuarioIngreso;
    }

    public void setIdUsuarioIngreso(Long idUsuarioIngreso) {
        this.idUsuarioIngreso = idUsuarioIngreso;
    }
}
