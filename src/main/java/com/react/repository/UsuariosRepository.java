package com.react.repository;

import com.react.dtos.UsuariosExternosDto;
import com.react.models.Usuarios;
import com.react.projections.UsuarioInternoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByCorreo(String correo);

    @Query(value="select u.dpi as dpi, u.correo as correo, concat(u.nombre,' ',u.apellidos) as nombre FROM react.usuarios u\n" +
            "where u.dpi != :usuario",nativeQuery = true)
    public List<UsuarioInternoProjection> findUsuariosInternos(@Param("usuario") String usuario);

}
