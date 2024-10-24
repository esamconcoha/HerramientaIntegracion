package com.react.controllers;

import com.react.dtos.UsuarioConversacionDto;
import com.react.models.Conversaciones;
import com.react.service.ConversacionesSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversaciones")
public class ConversacionesController {
    @Autowired
    private ConversacionesSvc service;


    @PostMapping("/crearConversacion")
    public void crearConversacion(@RequestBody List<UsuarioConversacionDto> usuarios){
        System.out.println("objeto recibido"+ usuarios);
        this.service.crearConversacion(usuarios);
    }


}
