package com.react.controllers;

import com.react.models.UsuarioConversacion;
import com.react.service.UsuarioConversacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios-conversacion")
public class UsuarioConversacionController {
    @Autowired
    private UsuarioConversacionSvc service;


    @GetMapping("/obtener-usuarios-conversacion/{usuario}")
    public ResponseEntity<List<UsuarioConversacion>> obtenerUsuariosConversacion(@PathVariable String usuario){
        return ResponseEntity.ok(service.findConversacionesByUsuario(usuario));
    }


}
