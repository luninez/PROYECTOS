import { Routes } from '@angular/router';

import { RecursosComponent } from './recursos/recursos.component';

export const DashboardRoutes: Routes = [
  { path: '',
  children: [
    {
      path: 'dashboard',
      component: RecursosComponent
    }
  ]
  }
];
