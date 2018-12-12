import { Routes } from '@angular/router';
import { RecursosComponent } from './recursos/recursos.component';
import { DashboardComponent } from './dashboard.component';

export const DashboardRoutes: Routes = [
  { path: '',
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'recursos', component: RecursosComponent },
    ]
  }
];
