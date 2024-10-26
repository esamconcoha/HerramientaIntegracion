package com.example.notificaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notificaciones")
@NoArgsConstructor
@AllArgsConstructor
public class Notificaciones {
    @Id
    @Column(name = "id_notificacion")
    private Long idNotificacion;

    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;

    @Column(name = "fecha_notificacion")
    private java.sql.Date fechaNotificacion;

    @Column(name = "correo_notificacion")
    private String correoNotificacion;

    public Long getIdNotificacion() {
        return this.idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTipoNotificacion() {
        return this.tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public java.sql.Date getFechaNotificacion() {
        return this.fechaNotificacion;
    }

    public void setFechaNotificacion(java.sql.Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getCorreoNotificacion() {
        return this.correoNotificacion;
    }

    public void setCorreoNotificacion(String correoNotificacion) {
        this.correoNotificacion = correoNotificacion;
    }
}
