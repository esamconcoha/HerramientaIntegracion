package com.react.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "mensajes", schema = "react")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mensajes {
    @Id
    @Column(name = "id_mensaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensaje;

    @Column(name = "descripcion_mensaje")
    private String descripcionMensaje;

    @Column(name = "id_usuario_mensaje")
    private String idUsuarioMensaje;

    @Column(name = "id_conversacion")
    private Long idConversacion;

    @Column(name = "fecha_hora_mensaje")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaHoraMensaje;


}
