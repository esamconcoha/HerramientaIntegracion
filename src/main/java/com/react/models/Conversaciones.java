package com.react.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conversaciones", schema = "react")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Conversaciones {
    @Id
    @Column(name = "id_conversacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConversacion;

    @Column(name = "estado_conversacion")
    private Boolean estadoConversacion;

}
