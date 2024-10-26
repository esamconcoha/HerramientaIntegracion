import { Component, OnInit } from '@angular/core';
interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}
@Component({
  selector: 'app-comentarios',
  templateUrl: './comentarios.component.html',
  styleUrls: ['./comentarios.component.css']
})
export class ComentariosComponent implements OnInit {
//abrir y cerrar sidebar
isSideNavCollapsed = false;
screenWidth = 0;
  constructor() { }

  ngOnInit() {
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

}
