package com.example.documentos.controllers;

import com.example.documentos.commons.CommonController;
import com.example.documentos.models.Documentos;
import com.example.documentos.services.DocumentosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentos")
public class DocumentosController extends CommonController<Documentos, DocumentosService> {

}
