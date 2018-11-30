import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatIconModule, MatCardModule, MatButtonModule, MatListModule, MatProgressBarModule, MatMenuModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';

import {MatTableModule} from '@angular/material/table';

import { DashboardComponent } from './dashboard.component';
import { DashboardRoutes } from './dashboard.routing';
import { DialogoEditRecursoComponent } from './dialogo-edit-recurso/dialogo-edit-recurso.component';
import { DialogoNewRecursoComponent } from './dialogo-new-recurso/dialogo-new-recurso.component';
import { DialogoDeleteRecursoComponent } from './dialogo-delete-recurso/dialogo-delete-recurso.component';
import { DialogoAddRecursoComponent } from './dialogo-add-recurso/dialogo-add-recurso.component';
import { RecursosComponent } from './recursos/recursos.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(DashboardRoutes),
    MatIconModule,
    MatCardModule,
    MatButtonModule,
    MatListModule,
    MatProgressBarModule,
    MatMenuModule,
    FlexLayoutModule,
    MatTableModule
  ],
  declarations: [
    DashboardComponent,
    DialogoEditRecursoComponent,
    DialogoNewRecursoComponent,
    DialogoDeleteRecursoComponent,
    DialogoAddRecursoComponent,
    RecursosComponent
  ]
})

export class DashboardModule {}