package com.react.service.implement;

import com.react.dtos.UsuarioConversacionDto;
import com.react.models.Conversaciones;
import com.react.models.UsuarioConversacion;
import com.react.repository.ConversacionesRepository;
import com.react.repository.UsuarioConversacionRepository;
import com.react.service.ConversacionesSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversacionesSvcImpl implements ConversacionesSvc {
    @Autowired
    private ConversacionesRepository repository;
    @Autowired
    private UsuarioConversacionRepository ucRepository;

    @Override
    public void crearConversacion(List<UsuarioConversacionDto> usuarios){
        Conversaciones conversacion = new Conversaciones();
        conversacion.setEstadoConversacion(true);
        this.repository.save(conversacion);
        List<UsuarioConversacion> usuariosConversacion= new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            UsuarioConversacion usuariosconversacionRegistro= new UsuarioConversacion();
            usuariosconversacionRegistro.setUsuario(usuarios.get(i).getUsuario());
            usuariosconversacionRegistro.setCorreoUsuario(usuarios.get(i).getCorreo());
            usuariosconversacionRegistro.setIdConversacion(conversacion.getIdConversacion());
            usuariosConversacion.add(usuariosconversacionRegistro);
        }
        this.ucRepository.saveAll(usuariosConversacion);
    }


}
