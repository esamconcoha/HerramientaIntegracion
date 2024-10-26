import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { token } from '../clases/token';
import { usuarioSesion } from '../clases/usuario';

@Injectable({
  providedIn: 'root'
})
export class SesionService {
  private baseUrl = environment.apiUrl;
constructor(private httpClient: HttpClient) { }

iniciarSesion(sesion:usuarioSesion): Observable<token> {
  return this.httpClient.post<token>(`${this.baseUrl}publico/authenticate`, sesion);
}

}
