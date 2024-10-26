export interface usuarioSesion {
    username:string;
    password:string;
}

//estos vienen del servicio de capi
export interface usuarioConversacion{
    correo:string;
    dpi:string;
    nombre:string;
}

//estos se enviaran al back para crear la conversacion
export interface usuarioConversacionEnviar{
    correo?:string;
    usuario?:string;
}