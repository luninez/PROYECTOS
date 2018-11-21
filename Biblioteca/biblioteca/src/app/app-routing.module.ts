import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'session',
    children: [{
      path: '',
      loadChildren: './session/session.module#SessionModule'
    }]
  },
  {
    path: 'dasboard',
    children: [{
      path: '',
      loadChildren: './dasboard/dasboard.module#DasboardModule'
    }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
