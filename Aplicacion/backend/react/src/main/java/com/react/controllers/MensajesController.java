package com.react.controllers;

import com.react.dtos.OrdenMensajeDto;
import com.react.projections.OrdenMensajeProjection;
import com.react.service.MensajesSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes")
public class MensajesController {

    @Autowired
    private MensajesSvc service;

    @GetMapping("/ordenMensajes/{idConversacion}")
    public ResponseEntity<List<OrdenMensajeProjection>> findOrdenMensajes(@PathVariable Integer idConversacion){
        return ResponseEntity.ok(service.findOrdenMensajes(idConversacion));
    }

}
