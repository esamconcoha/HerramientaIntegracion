import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

import Swal from 'sweetalert2';
import { TokenService } from '../general/servicios/token.service';



@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
 
  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }
 
 
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.tokenService.getToken()) {
        Swal.fire({
        icon: 'error',
        title: 'Usuario no autenticado',
        text: 'Por favor inicie sesión para continuar',
      })
      this.router.navigate(['login']);
      return false;
    }
      return true;
  }
  
}
