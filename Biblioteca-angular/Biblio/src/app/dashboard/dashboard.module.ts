import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatIconModule,
  MatCardModule,
  MatButtonModule,
  MatListModule,
  MatProgressBarModule,
  MatMenuModule,
  MatInputModule,
  MatSnackBarModule,
  MatDialogModule,
  MatSelectModule} from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';

import { DashboardComponent } from './dashboard.component';
import { DashboardRoutes } from './dashboard.routing';

import { DialogoEditRecursoComponent } from '../dashboard/recursos/dialogo-edit-recurso/dialogo-edit-recurso.component';
import { DialogoDeleteRecursoComponent } from '../dashboard/recursos/dialogo-delete-recurso/dialogo-delete-recurso.component';
import { DialogoAddRecursoComponent } from '../dashboard/recursos/dialogo-add-recurso/dialogo-add-recurso.component';
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
    MatTableModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSnackBarModule,
    MatDialogModule,
    MatSelectModule
  ],
  declarations: [
    DashboardComponent,
    DialogoEditRecursoComponent,
    DialogoDeleteRecursoComponent,
    DialogoAddRecursoComponent,
    RecursosComponent
  ],
  entryComponents: [
    DialogoEditRecursoComponent,
    DialogoDeleteRecursoComponent,
    DialogoAddRecursoComponent
  ]
})

export class DashboardModule {}