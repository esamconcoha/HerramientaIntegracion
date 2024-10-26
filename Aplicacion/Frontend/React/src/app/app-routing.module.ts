import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuardGuard } from './helpers/auth.guard';

const routes: Routes = [
{path:'login',component:LoginComponent},
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'gestion-interna',
  canActivate: [AuthGuardGuard],
  children:[
    {path:'',loadChildren:()=>import('./gestion-interna/gestion-interna-routing.module').then(m=>m.GestionInternaRoutingModule)},
  ]
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
