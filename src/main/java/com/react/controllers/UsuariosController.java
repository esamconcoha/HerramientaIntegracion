package com.react.controllers;

import com.react.dtos.ListUsuariosExternosDto;
import com.react.dtos.UsuariosExternosDto;
import com.react.models.Usuarios;
import com.react.service.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioSvc usuarioServices;

    private static Logger logger
            = Logger.getLogger(
            UsuariosController.class.getName());

    @PostMapping("/guardarUsuario")
    public Usuarios guardarUsuario(@RequestBody Usuarios usuario){
        logger.log(Level.INFO, "Se ejecuta el metodo guardarUsuario");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);
        return usuarioServices.save(usuario);
    }

    @GetMapping("/getUsuariosExternos")
    public ResponseEntity<List<UsuariosExternosDto>> findUsuariosExternos(){
        return ResponseEntity.ok(usuarioServices.findUsuariosExternos());
    }


}
