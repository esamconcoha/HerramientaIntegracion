package com.react.controllers;

import com.react.Utils.AuthorizeUtil;
import com.react.dtos.UsuarioConversacionDto;
import com.react.models.UsuarioConversacion;
import com.react.projections.OrdenMensajeProjection;
import com.react.service.ConversacionesSvc;
import com.react.service.MensajesSvc;
import com.react.service.UsuarioConversacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/publico/inter")
public class PublicoController {
    @Autowired
    private UsuarioConversacionSvc serviceUC;
    @Autowired
    private ConversacionesSvc serviceC;

    @Autowired
    private MensajesSvc serviceM;

    @Autowired
    private AuthorizeUtil authorizeUtil;

    @GetMapping("/obtener-usuarios-conversacion/{usuario}")
    public ResponseEntity<List<UsuarioConversacion>> obtenerUsuariosConversacion(@PathVariable String usuario){
        System.out.println("entra al primer metodo");
        this.authorizeUtil.validCredentials();
        return ResponseEntity.ok(serviceUC.findConversacionesByUsuario(usuario));
    }

    @PostMapping("/crearConversacion")
    public void crearConversacion(@RequestBody List<UsuarioConversacionDto> usuarios){
        this.authorizeUtil.validCredentials();
        System.out.println("objeto recibido"+ usuarios);
        this.serviceC.crearConversacion(usuarios);
    }

    @GetMapping("/ordenMensajes/{idConversacion}")
    public ResponseEntity<List<OrdenMensajeProjection>> findOrdenMensajes(@PathVariable Integer idConversacion){
        this.authorizeUtil.validCredentials();
        return ResponseEntity.ok(serviceM.findOrdenMensajes(idConversacion));
    }




}
