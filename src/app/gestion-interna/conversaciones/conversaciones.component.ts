import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { conversacion } from 'src/app/general/clases/conversacion';
import { usuarioConversacion, usuarioConversacionEnviar } from 'src/app/general/clases/usuario';
import { ChatService } from 'src/app/general/servicios/chat.service';
import { ConversacionesService } from 'src/app/general/servicios/conversaciones.service';
import { TokenService } from 'src/app/general/servicios/token.service';
import { UsuariosService } from 'src/app/general/servicios/usuarios.service';
import { CrearConversacionComponent } from './crear-conversacion/crear-conversacion.component';
import { DialogConfig } from '@angular/cdk/dialog';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}
@Component({
  selector: 'app-conversaciones',
  templateUrl: './conversaciones.component.html',
  styleUrls: ['./conversaciones.component.css']
})
export class ConversacionesComponent implements OnInit {

  listaConversaciones:conversacion[]=[];
  listaConversacionesGeneral:conversacion[]=[];
  listaUsuariosConversacion:usuarioConversacion[]=[];
  usuarioPropio!:usuarioConversacionEnviar;
  //abrir y cerrar sidebar
isSideNavCollapsed = false;
screenWidth = 0;

  constructor(private tokenService: TokenService,
    private service:ConversacionesService,
    private router: Router,
    private chatService:ChatService,
    private usuarioService:UsuariosService,
    public dialog:MatDialog
  ) { }

  ngOnInit() {
    this.traerConversacion();
    console.log(this.tokenService.getToken());
    console.log(this.listaConversaciones);
  }

    //abrir y cerrar sidebar
    onToggleSideNav(data: SideNavToggle): void {
      this.screenWidth = data.screenWidth;
      this.isSideNavCollapsed = data.collapsed;
    }
  
    //que las clases de css cambien dependiendo si el sidebar está desplegado o no
    getBodyClass(): string {
      let styleclass = '';
      if (this.isSideNavCollapsed && this.screenWidth > 768) {
        styleclass = 'body-trimmed';
      } else if (this.isSideNavCollapsed && this.screenWidth <= 768 && this.screenWidth > 0) {
        styleclass = 'body-md-screen';
      }
      return styleclass;
    }


  traerConversacion(){
    const usuarioActual= this.tokenService.getUserName();

    this.service.traerConversaciones(this.tokenService.getUserName()).subscribe(conversaciones=>{
      this.listaConversacionesGeneral=conversaciones;
      this.datosUsuarioPropio();
      this.listaConversaciones=this.listaConversacionesGeneral.filter(
        (conversacion)=>conversacion.usuario !== usuarioActual
      )
    })
  }
 
  consumirUsuarios(){
    const dialogConfig = new MatDialogConfig();
   
    dialogConfig.maxWidth = '800px'; // establece el ancho máximo de la ventana a 800px
    dialogConfig.width = '600px'; // establece el ancho de la ventana a 600px
    dialogConfig.data={usuarioConversacion:this.usuarioPropio};
    this.dialog.open(CrearConversacionComponent,dialogConfig);
  }

  abrirConversacion(idConversacion:number){
    
    this.chatService.setIdConversacion(idConversacion.toString());
    this.router.navigate(['chat/',this.tokenService.getUserName()]);

  }

  datosUsuarioPropio(){
    const usuarioActual = this.tokenService.getUserName();
    console.log("el usuario actual",usuarioActual);
    // Buscar la conversación donde el usuario coincide con el usuario actual
    const conversacionPropia = this.listaConversacionesGeneral.find(
      (conversacion) => conversacion.usuario === usuarioActual
    );
  
    // Si se encontró la conversación, llenar la variable usuarioPropio
    if (conversacionPropia) {
      this.usuarioPropio = {
        correo: conversacionPropia.correoUsuario,  // Obtener el correo
        usuario: this.tokenService.getUserName(),   // Obtener el DPI desde tokenService
      };
      console.log('Usuario propio:', this.usuarioPropio);
    } else {
      console.warn('No se encontró la conversación del usuario actual.');
    }
  

  }

}
