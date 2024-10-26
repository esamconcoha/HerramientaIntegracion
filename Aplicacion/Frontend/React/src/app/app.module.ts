import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { GeneralModule } from './general/general.module';

import { MatCardModule } from '@angular/material/card';
import { GestionInternaModule } from './gestion-interna/gestion-interna.module';
import { Interceptor } from './helpers/auth.interceptor';

@NgModule({
  declarations: [AppComponent, LoginComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    GeneralModule,
    MatCardModule,
    ReactiveFormsModule,
    GestionInternaModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true
    }
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}
