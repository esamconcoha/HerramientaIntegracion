import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GestionInternaRoutingModule } from './gestion-interna-routing.module';
import { ChatComponent } from './chat/chat.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConversacionesComponent } from './conversaciones/conversaciones.component';
import {  MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { AppComponent } from '../app.component';
import { Interceptor } from '../helpers/auth.interceptor';
import { CrearConversacionComponent } from './conversaciones/crear-conversacion/crear-conversacion.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidebarComponent } from './sidebar/sidebar.component';
import { BodyComponent } from './body/body.component';
import { ComentariosComponent } from './comentarios/comentarios.component';
import { TareasComponent } from './tareas/tareas.component';


@NgModule({
  declarations: [ChatComponent,
    ConversacionesComponent,
    CrearConversacionComponent,
    SidebarComponent,
    BodyComponent,
    ComentariosComponent,
    TareasComponent
  ],
  imports: [
    CommonModule,
    GestionInternaRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatDialogModule,
    MatInputModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatSelectModule,
    MatIconModule,
     MatButtonModule,
    MatListModule,
    MatStepperModule,
    MatCheckboxModule,
    BrowserAnimationsModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true
    }
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GestionInternaModule { }
