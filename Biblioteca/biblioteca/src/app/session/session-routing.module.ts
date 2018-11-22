import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// COMPONENTES DEL PROGRAMA
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: '', component: LoginComponent }
];

@NgModule({
  declarations: [
    LoginComponent, SignupComponent],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class SessionRoutingModule { }
