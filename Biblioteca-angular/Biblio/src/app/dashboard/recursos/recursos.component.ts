import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { MatSnackBar } from '@angular/material/snack-bar';

import { RecursosService } from './recursos.service';
import { AuthService } from '../../session/signin/Service/auth.service';
import { DialogoEditRecursoComponent } from './dialogo-edit-recurso/dialogo-edit-recurso.component';
import { DialogoDeleteRecursoComponent } from './dialogo-delete-recurso/dialogo-delete-recurso.component';
import { DialogoAddRecursoComponent } from './dialogo-add-recurso/dialogo-add-recurso.component';
import { RecursoDto } from '../dto/recursoDto.dto';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.scss']
})
export class RecursosComponent implements OnInit {
  displayedColumns: string[] = ['id', 'title', 'autor', 'anyo', 'content', 'free', 'type', 'category', 'acciones'];
  dataRecursos;

  constructor(
    private recursoService: RecursosService,
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

  openDialogoEditarRecurso() {
    const dialogoEditRecurso = this.dialog.open(DialogoEditRecursoComponent);

    dialogoEditRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso editado');
    });

  }

  openDialogoEliminarRecurso(element: RecursoDto) {
    const dialogoDeleteRecurso = this.dialog.open(DialogoDeleteRecursoComponent, {
      data: { recurso: element },
    });

    dialogoDeleteRecurso.afterClosed().subscribe(result => {
      this.recursoService.eliminarRecurso().subscribe(res => {
        this.getListaRecurso('Recurso eliminado');
      });
    });

  }

  openDialogoAnyadirRecurso() {
    const dialogoAddRecurso = this.dialog.open(DialogoAddRecursoComponent);

    dialogoAddRecurso.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso añadido');
    });

  }

  isAdmin() {
    return this.authService.isAdmin();
  }

}
