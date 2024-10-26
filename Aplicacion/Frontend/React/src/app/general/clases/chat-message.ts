export interface mensaje{
descripcionMensaje:string;
idUsuarioMensaje:string;
idConversacion:string;
}


export interface historialMensajes{
  descripcionMensaje:string,
  idUsuarioMensaje:string,
  idConversacion:string
}

 export interface MensajeConSide extends mensaje {
    message_side: 'sender' | 'receiver';
  }
  