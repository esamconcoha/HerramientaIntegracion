package com.react.controllers;

import com.react.Utils.AuthorizeUtil;
import com.react.dtos.UsuarioConversacionDto;
import com.react.models.UsuarioConversacion;
import com.react.models.Usuarios;
import com.react.projections.OrdenMensajeProjection;
import com.react.seguridad.AuthenticationRequest;
import com.react.seguridad.AuthenticationResponse;
import com.react.seguridad.JwtUtilService;
import com.react.seguridad.UserDetailsServiceImpl;
import com.react.service.ConversacionesSvc;
import com.react.service.MensajesSvc;
import com.react.service.UsuarioConversacionSvc;
import com.react.service.implement.UsuarioSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/publico")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl usuarioDetailService;


    @Autowired
    private UsuarioSvcImpl usuarioServicio;
    @Autowired
    private UsuarioConversacionSvc serviceUC;
    @Autowired
    private ConversacionesSvc serviceC;

    @Autowired
    private MensajesSvc serviceM;

    @Autowired
    private AuthorizeUtil authorizeUtil;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static Logger logger
            = Logger.getLogger(
            AuthController.class.getName());
    @Autowired
    private JwtUtilService jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        String contraseña = getContraseña(request.getUsername()); //obtiene la contraseña del usuario
        if (contraseña != null && passwordEncoder.matches(request.getPassword(), contraseña)) { // si el usuario existe y la contraseña es correcta
            try {
                logger.log(Level.INFO, "se ejecuta el metodo createToken antes de authenticate");
                UserDetails userDetails = usuarioDetailService.loadUserByUsername(request.getUsername());
                logger.log(Level.INFO, "se ejecuta el metodo createToken despues de authenticate");
                String jwt = jwtUtil.generateToken(userDetails);
                String nombre = getDpi(request.getUsername()).get("dpi");

                return new ResponseEntity<>(new AuthenticationResponse(jwt, nombre), HttpStatus.OK);
            } catch (BadCredentialsException e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }else{
            System.out.println("false");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    public Map<String, String> getDpi(String username){
        Optional<Usuarios> usuario = usuarioServicio.findByCorreo(username);
        String dpi = usuario.get().getDpi();
        Map<String, String> response = new HashMap<>();
        response.put("dpi", dpi);
        return response;
    }


    public String getContraseña(String username){
        Optional<Usuarios> usuario = usuarioServicio.findByCorreo(username);
        String contraseña = usuario.get().getPassword();
        return contraseña;
    }


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
