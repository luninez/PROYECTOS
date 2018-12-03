import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { MatSnackBar } from '@angular/material/snack-bar';

import { RecursoService } from './recurso.service';
import { AuthService } from '../../session/signin/Service/auth.service';
import { DialogoEditRecursoComponent } from './dialogo-edit-recurso/dialogo-edit-recurso.component';
import { DialogoDeleteRecursoComponent } from './dialogo-delete-recurso/dialogo-delete-recurso.component';
import { DialogoAddRecursoComponent } from './dialogo-add-recurso/dialogo-add-recurso.component';
import { DialogoNewRecursoComponent } from './dialogo-new-recurso/dialogo-new-recurso.component';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.scss']
})
export class RecursosComponent implements OnInit {
  displayedColumns: string[] = ['id', 'title', 'autor', 'anyo', 'content', 'free', 'type', 'category', 'acciones'];
  dataRecursos;

  constructor(
    private recursoService: RecursoService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog,
    public authService: AuthService) { }

  ngOnInit() {
    this.recursoService.getAllRecurso().subscribe(recursos => {
      this.dataRecursos = new MatTableDataSource(recursos);
    });
  }

  applyFilter(filterValue: string) {
    this.dataRecursos.filter = filterValue.trim().toLowerCase();
  }

  getListaRecurso(mensaje: string) {
    this.recursoService.getAllRecurso().subscribe(listaRecursos => {
      this.dataRecursos = listaRecursos;

      this.snackBar.open(mensaje, 'Cerrar', {
        duration: 3000,
        verticalPosition: 'top'
      });
    }, error =>  {
      this.snackBar.open('Error al obtener recursos', 'Cerrar', {
        duration: 3000,
      });
    });
  }

  openDialogoNuevoRecurso() {
    const dialogoNewRecurso = this.dialog.open(DialogoNewRecursoComponent);

    dialogoNewRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso creado');
    });

  }

  openDialogoEditarRecurso() {
    const dialogoEditRecurso = this.dialog.open(DialogoEditRecursoComponent);

    dialogoEditRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso editado');
    });

  }

  openDialogoEliminarRecurso() {
    const dialogoDeleteRecurso = this.dialog.open(DialogoDeleteRecursoComponent);

    dialogoDeleteRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso eliminado');
    });

  }

  openDialogoAñadirRecurso() {
    const dialogoAddRecurso = this.dialog.open(DialogoAddRecursoComponent);

    dialogoAddRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso añadido');
    });

  }

  isAdmin() {
    return this.authService.isAdmin();
  }

}
