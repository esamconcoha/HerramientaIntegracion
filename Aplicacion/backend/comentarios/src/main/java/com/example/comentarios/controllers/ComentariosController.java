package com.example.comentarios.controllers;

import com.example.comentarios.commons.CommonController;
import com.example.comentarios.models.Comentarios;
import com.example.comentarios.services.ComentariosSvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController extends CommonController<Comentarios, ComentariosSvc> {
}
