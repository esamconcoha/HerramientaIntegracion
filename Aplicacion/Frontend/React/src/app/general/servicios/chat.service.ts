import { Injectable } from '@angular/core';
import { Stomp } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { environment } from 'src/environments/environment';
import { historialMensajes, mensaje } from '../clases/chat-message';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private baseUrl = environment.apiUrl;
  private stompClient: any;
  //este es el listener
  private messageSubject: BehaviorSubject<mensaje[]> = new BehaviorSubject<mensaje[]>([]);
private historialMensajesSubject: BehaviorSubject<historialMensajes[]> = new BehaviorSubject<historialMensajes[]>([]);
  private idConversacion: string = '';
  constructor(
    private hhtp: HttpClient
  ) {}

  initConnectionSocket() {
    const socket = new SockJS(this.baseUrl + 'chat-socket');
    console.log('esta es la ruta armada',socket);
    this.stompClient = Stomp.over(socket);
  }

  joinRoom(roomId: string) {
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe(`/topic/${roomId}`, (message: any) => {
        const messageContent = JSON.parse(message.body);
        const currenteMessage= this.messageSubject.getValue();
        currenteMessage.push(messageContent);
        this.messageSubject.next(currenteMessage);
      });

    })
   
  }

  sendMessage(roomId: string, mensaje: mensaje) {
    this.stompClient.send(`/app/chat/${roomId}`, {}, JSON.stringify({
      descripcionMensaje: mensaje.descripcionMensaje,
      idUsuarioMensaje: mensaje.idUsuarioMensaje,
      idConversacion: mensaje.idConversacion
    }));
    console.log("waaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    console.log(mensaje,roomId);
  }
 
  //servicio que lo que hace es devolver la información que tienen almacenada el listener
  /*getMessageSubject(){
   return this.messageSubject.asObservable();
  }*/
 /* getMessageSubject2(idConversacion:number):Observable<historialMensajes[]>{
    return this.hhtp.get<historialMensajes[]>(`${this.baseUrl}mensajes/ordenMensajes/${idConversacion}`);
  }*/

  getMessageSubject(idConversacion: number): Observable<mensaje[]> {
    this.hhtp.get<historialMensajes[]>(`${this.baseUrl}mensajes/ordenMensajes/${idConversacion}`)
      .subscribe(mensajes => {
        this.messageSubject.next(mensajes);
      });
      return this.messageSubject.asObservable();
    }


  setIdConversacion(id: string) {
    this.idConversacion = id;
  }

  getIdConversacion(): string {
    return this.idConversacion;
  }


}
