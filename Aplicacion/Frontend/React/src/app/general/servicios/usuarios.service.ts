import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { usuarioConversacion } from '../clases/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private baseUrl = environment.apiUrl;

constructor(private http:HttpClient) { }

traerUsuariosForConversacion():Observable<usuarioConversacion[]>{
  return this.http.get<usuarioConversacion[]>(`${this.baseUrl}Usuarios/getUsuariosExternos`);
}

trearUsuariosInternos(idUsuario:string):Observable<usuarioConversacion[]>{
  return this.http.get<usuarioConversacion[]>(`${this.baseUrl}Usuarios/getUsuariosInternos/${idUsuario}`);
}
  

}
