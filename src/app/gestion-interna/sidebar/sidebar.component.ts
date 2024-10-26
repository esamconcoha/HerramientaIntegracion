import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { navBarData } from './nav-data';
import { Router } from '@angular/router';
interface SideNavToggle{
  screenWidth: number;
  collapsed:boolean;
}
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  navData:any=[];
  @Output() onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();
  
  collapsed=false;
  screenWidth: number= 0;

  

  constructor(private router: Router) { 
    
  }

  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
    this.mostrarData();
  }

  // autenticar() {  
  //   if(this.tokenService.getToken() == null){
  //     /*
  //     Swal.fire({
  //       title: '¿QUIEN SOS?',
  //       text: 'No se quien shota sos,pero te voy a recagar a piñas',
  //       imageUrl: '../../../assets/imagenes/Autenticacion.jpg',
  //       imageWidth: 400,
  //       imageHeight: 200,
  //       imageAlt: 'Custom image',
  //     })
  //     */     
  //     Swal.fire({
  //       icon: 'error',
  //       title: 'Usuario no autenticado',
  //       text: 'Por favor inicie sesión para continuar',
  //     })
  //     this.router.navigate(['login']);
  //   } 

  // }



  toggleCollapse():void{
    this.collapsed=!this.collapsed;
    this.onToggleSideNav.emit({collapsed: this.collapsed,  screenWidth: this.screenWidth})
  }

  closeSidenav():void{
    this.collapsed=false;
    this.onToggleSideNav.emit({collapsed: this.collapsed,  screenWidth: this.screenWidth})
  }



  mostrarData(){
   this.navData=navBarData;

  }

}
