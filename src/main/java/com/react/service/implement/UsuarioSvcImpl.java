package com.react.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.clients.SSAPConsumer;
import com.react.dtos.ListUsuariosExternosDto;
import com.react.dtos.UsuariosExternosDto;
import com.react.models.Usuarios;
import com.react.projections.UsuarioInternoProjection;
import com.react.repository.UsuariosRepository;
import com.react.service.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSvcImpl implements UsuarioSvc {

    @Autowired
    private UsuariosRepository repositorio;

    @Autowired
    private SSAPConsumer consumer;


    @Override
    public Optional<Usuarios> findByCorreo(String correo) {
        return repositorio.findByCorreo(correo);
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public List<UsuariosExternosDto> findUsuariosExternos() {
        ResponseEntity<List<UsuariosExternosDto>> response = this.consumer.response(null, "user/get-usuarios", new ParameterizedTypeReference<List<UsuariosExternosDto>>() {}, HttpMethod.GET
        );

        return response.getBody() != null ? response.getBody() : new ArrayList<>();
    }


    @Override
    public List<UsuarioInternoProjection> findUsuariosInternos(String usuario){
        return this.repositorio.findUsuariosInternos(usuario);
    }
}
