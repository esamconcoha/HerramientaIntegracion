import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SesionService } from '../general/servicios/sesion.service';
import { TokenService } from '../general/servicios/token.service';
import Swal from 'sweetalert2';
import { usuarioSesion } from '../general/clases/usuario';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogueo:FormGroup;
  constructor(private fb:FormBuilder,
    private router: Router,
    private sesionService:SesionService,
    private tokenService:TokenService) { 
      this.formLogueo= this.fb.group({
        usuario:['', Validators.required],
        password:['',Validators.required]
      })
    }

  ngOnInit() {
  }
  validarForm(){
    if(this.formLogueo.invalid){
      Swal.fire({
        title: 'Error',
        text: 'Por favor complete los campos obligatorios.',
        icon: 'error',
        confirmButtonText: 'OK'
      });
    }else{
      this.ingresar();
    }
  }
  
  
  ingresar(){
    console.log(this.formLogueo.value);
  
    const sesion:usuarioSesion={
      username:this.formLogueo.get('usuario')?.value,
      password:this.formLogueo.get('password')?.value
    }
  
    this.sesionService.iniciarSesion(sesion).subscribe(token=>{
      Swal.fire({
        icon: 'success',
        timerProgressBar: true,
        title: 'Bienvenido ' + this.formLogueo.get('usuario')?.value,
        showConfirmButton: false,
        timer: 1000
      })
      this.tokenService.setToken(token.jwt);
      this.tokenService.setUserName(token.nombre);
      this.tokenService.setRol(token.rol);
      localStorage.clear();
  
     this.router.navigateByUrl('/gestion-interna/conversaciones'); 
    },error => Swal.fire('ERROR', `El usuario y/o la contraseña ingresados son incorrectos por favor intente de nuevo`, `error`))
  }
    
}
