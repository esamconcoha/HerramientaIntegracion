package com.react.service;

import com.react.dtos.ListUsuariosExternosDto;
import com.react.dtos.UsuariosExternosDto;
import com.react.models.Usuarios;
import com.react.projections.UsuarioInternoProjection;

import java.util.List;
import java.util.Optional;

public interface UsuarioSvc {
    public Optional<Usuarios> findByCorreo(String correo);

    public Usuarios save(Usuarios usuario);

    public List<UsuariosExternosDto> findUsuariosExternos();

    public List<UsuarioInternoProjection> findUsuariosInternos(String usuario);
}
