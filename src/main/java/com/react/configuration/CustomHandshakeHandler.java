package com.react.configuration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.util.Map;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {

    protected boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            org.springframework.web.socket.WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {

        // Extraer el token JWT desde los headers
        String token = request.getHeaders().getFirst("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remover "Bearer " del token
            // Aquí debes validar el token
            boolean valid = validarToken(token);
            if (valid) {
                attributes.put("user", obtenerUsuarioDesdeToken(token)); // Almacenar usuario autenticado
                return true; // Permitir el handshake
            }
        }

        return false; // Bloquear la conexión si el token no es válido
    }

    private boolean validarToken(String token) {
        // Lógica para validar el JWT
        // Ej: usando JwtUtils.validateToken(token);
        return true; // Simulación
    }

    private String obtenerUsuarioDesdeToken(String token) {
        // Extraer el usuario o claims desde el token
        return "usuarioEjemplo"; // Simulación
    }
}
