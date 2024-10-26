package com.example.documentos.services.SvcImpl;

import com.example.documentos.commons.CommonSvcImpl;
import com.example.documentos.models.Documentos;
import com.example.documentos.repositories.DocumentosRepository;
import com.example.documentos.services.DocumentosService;
import org.springframework.stereotype.Service;

@Service
public class DocumentosSvcImpl extends CommonSvcImpl<Documentos, DocumentosRepository> implements DocumentosService {
}
