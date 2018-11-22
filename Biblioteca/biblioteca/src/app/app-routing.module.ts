import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'session/login', pathMatch: 'full'},
  {
    path: '',
    children: [{
      path: 'session',
      loadChildren: './session/session-routing.module#SessionRoutingModule'
    }]
  },
  {
    path: '',
    children: [{
      path: '',
      loadChildren: './dasboard/dasboard-routing.module#DashboardRoutingModule'
    }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
