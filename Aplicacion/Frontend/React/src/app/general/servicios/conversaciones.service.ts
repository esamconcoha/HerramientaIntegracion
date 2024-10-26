import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { conversacion } from '../clases/conversacion';
import { Observable } from 'rxjs';
import { usuarioConversacion, usuarioConversacionEnviar } from '../clases/usuario';

@Injectable({
  providedIn: 'root'
})
export class ConversacionesService {
  private baseUrl = environment.apiUrl;

  
constructor(private http: HttpClient) { }

traerConversaciones(idUsuario:string):Observable<conversacion[]>{
  
  return this.http.get<conversacion[]>(`${this.baseUrl}usuarios-conversacion/obtener-usuarios-conversacion/${idUsuario}`);
  console.log("llega aquí");
}

crearconversaciones(usuarios:usuarioConversacionEnviar[]):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}conversaciones/crearConversacion`,usuarios)
}

}
