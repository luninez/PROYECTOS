import { Component, OnInit } from '@angular/core';
import { Recurso } from './models/recurso';
import { RecursoService } from './recurso.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { DialogoNewRecursoComponent } from './dialogo-new-recurso/dialogo-new-recurso.component';

@Component({
  selector: 'app-lista-recurso',
  templateUrl: './lista-recurso.component.html',
  styleUrls: ['./lista-recurso.component.scss']
})
export class ListaRecursoComponent implements OnInit {
  displayedColumns: string[] = ['ID', 'titulo', 'autor', 'date', 'type', 'category', 'acciones'];
  dataSource: Recurso[];

  constructor(private recursoService: RecursoService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.getListaRecurso('Listado de notas cargado');
  }

  getListaRecurso(mensaje: string) {
    this.recursoService.getAllRecurso().subscribe(listaRecursos => {
      this.dataSource = listaRecursos;

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

  eliminarRecurso(element: Recurso) {
    this.snackBar.open(`Eliminando ${element.título}`, 'Cerrar', {
      duration: 3000,
    });
  }

}
