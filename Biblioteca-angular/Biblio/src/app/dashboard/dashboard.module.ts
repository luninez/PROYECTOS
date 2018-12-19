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
import { CategoriaComponent } from './categoria/categoria.component';
import { DialogoAddCategoriaComponent } from './categoria/dialogo-add-categoria/dialogo-add-categoria.component';
import { DialogoDeleteCategoriaComponent } from './categoria/dialogo-delete-categoria/dialogo-delete-categoria.component';
import { DialogoEditCategoriaComponent } from './categoria/dialogo-edit-categoria/dialogo-edit-categoria.component';

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
    RecursosComponent,
    CategoriaComponent,
    DialogoAddCategoriaComponent,
    DialogoDeleteCategoriaComponent,
    DialogoEditCategoriaComponent
  ],
  entryComponents: [
    DialogoEditRecursoComponent,
    DialogoDeleteRecursoComponent,
    DialogoAddRecursoComponent
  ]
})

export class DashboardModule {}
