import { usuarioConversacion, usuarioConversacionEnviar } from './../../../general/clases/usuario';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConversacionesService } from 'src/app/general/servicios/conversaciones.service';
import { TokenService } from 'src/app/general/servicios/token.service';
import { UsuariosService } from 'src/app/general/servicios/usuarios.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crear-conversacion',
  templateUrl: './crear-conversacion.component.html',
  styleUrls: ['./crear-conversacion.component.css']
})
export class CrearConversacionComponent implements OnInit {
  ListaUsuarios:usuarioConversacion[]=[];
  receptorConversacion:FormGroup;
  ListaUsuariosEnviar:usuarioConversacionEnviar[]=[];

  constructor(private usuarioService: UsuariosService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private conversacionService: ConversacionesService,
    private tokenService:TokenService
  ) {
    this.ListaUsuariosEnviar.push(this.data.usuarioConversacion);
    this.receptorConversacion = this.formBuilder.group({
    dpi:['',Validators.required]
    })
    
 
  }

  ngOnInit() {
    this.consumirUsuarios();
    console.log('el usuario que viene',this.data);
    this.consumirUsuariosInt();
  }



  consumirUsuarios(){
    this.usuarioService.traerUsuariosForConversacion().subscribe(dataUsuario=>{
      this.ListaUsuarios=dataUsuario;
      console.log(this.ListaUsuarios);
    })
   
  }

  consumirUsuariosInt(){
    this.usuarioService.trearUsuariosInternos(this.tokenService.getUserName()).subscribe((interno:usuarioConversacion[])=>{
      this.ListaUsuarios.push(...interno);
      console.log(this.ListaUsuarios);
    })
  }

  crearConversacion(){
 
   const usuarioElegido= this.ListaUsuarios.find(usuario => usuario.dpi === this.receptorConversacion.get('dpi')?.value);
    const usuarioEnviar:usuarioConversacionEnviar= {
      correo:usuarioElegido?.correo,
      usuario:usuarioElegido?.dpi
    }
    this.ListaUsuariosEnviar.push(usuarioEnviar);
    console.log("el listado a enviar pa crear conversacion");
    console.log(this.ListaUsuariosEnviar);
    this.conversacionService.crearconversaciones(this.ListaUsuariosEnviar).toPromise().then(conversacion=>{
      Swal.fire({
        titleText: `Se ha Creado la conversacion con exito`,
        icon: 'success',
        showCloseButton: true,
        showConfirmButton: false
      }).then(()=>{
        window.location.href='gestion-interna/conversaciones'
      });
      
    }).catch(error => {
      console.error("Error al crear la conversación:", error);
      Swal.fire({
        titleText: 'Error al crear la conversación',
        text: 'Ocurrió un error al intentar crear la conversación. Por favor, intenta nuevamente.',
        icon: 'error',
        showCloseButton: true,
        confirmButtonText: 'Aceptar'
      });
    });



  }
  

}
