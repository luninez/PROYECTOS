import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatIconModule,
          MatCardModule,
          MatButtonModule,
          MatListModule,
          MatProgressBarModule,
          MatMenuModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatTableDataSource, MatSort } from '@angular/material';
import { DataSource } from '@angular/cdk/table';


import { DashboardComponent } from './dashboard.component';
import { DashboardRoutes } from './dashboard.routing';
import { ListaRecursoComponent } from './lista-recurso/lista-recurso.component';
import { DialogoNewRecursoComponent } from './lista-recurso/dialogo-new-recurso/dialogo-new-recurso.component';
import { DialogoEditRecursoComponent } from './lista-recurso/dialogo-edit-recurso/dialogo-edit-recurso.component';
import { DialogoAddRecursoComponent } from './lista-recurso/dialogo-add-recurso/dialogo-add-recurso.component';
import { DialogoDeleteRecursoComponent } from './lista-recurso/dialogo-delete-recurso/dialogo-delete-recurso.component';

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
    MatToolbarModule,
    FormsModule,
    MatInputModule,
    MatTableDataSource,
    MatSort
  ],
  declarations: [
    DashboardComponent,
    ListaRecursoComponent,
    DialogoNewRecursoComponent,
    DialogoEditRecursoComponent,
    DialogoAddRecursoComponent,
    DialogoDeleteRecursoComponent
  ]
})

export class DashboardModule {
  dataSource;
}
