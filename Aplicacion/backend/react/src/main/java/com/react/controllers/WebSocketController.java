package com.react.controllers;

import com.react.models.Mensajes;
import com.react.service.MensajesSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    @Autowired
    private MensajesSvc mensajesSvc;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Mensajes chat(@DestinationVariable String roomId, Mensajes mensaje) {
        /*System.out.println("Mensaje recibido: " + mensaje.getDescripcionMensaje()+"idUsuario: "+ mensaje.getIdUsuarioMensaje()+
                "idConversacion: "+mensaje.getIdConversacion());*/
        return this.mensajesSvc.guardarMensaje(roomId, mensaje);

    }
}
