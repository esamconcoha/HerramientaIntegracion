package com.react.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioConversacionPk implements Serializable {
    private String usuario;
    private Long idConversacion;


}
