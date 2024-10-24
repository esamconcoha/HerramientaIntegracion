package com.react.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenMensajeDto {
    String descripcion;
    String usuarioMensaje;
}
