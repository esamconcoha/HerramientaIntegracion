import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatComponent } from './chat/chat.component';
import { ConversacionesComponent } from './conversaciones/conversaciones.component';
import { ComentariosComponent } from './comentarios/comentarios.component';
import { TareasComponent } from './tareas/tareas.component';

const routes: Routes = [
  {path:'',
    children:[
      {path:'chat/:userId',component:ChatComponent},
      {path:'conversaciones',component:ConversacionesComponent},
      {path:'comentarios',component:ComentariosComponent},
      {path:'tareas',component:TareasComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestionInternaRoutingModule { }
