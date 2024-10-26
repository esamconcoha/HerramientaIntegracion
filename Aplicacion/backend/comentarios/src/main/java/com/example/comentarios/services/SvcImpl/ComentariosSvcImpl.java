package com.example.comentarios.services.SvcImpl;

import com.example.comentarios.commons.CommonSvcImpl;
import com.example.comentarios.models.Comentarios;

import com.example.comentarios.repositories.ComentariosRepository;
import com.example.comentarios.services.ComentariosSvc;
import org.springframework.stereotype.Service;

@Service
public class ComentariosSvcImpl extends CommonSvcImpl<Comentarios, ComentariosRepository> implements ComentariosSvc {


}
