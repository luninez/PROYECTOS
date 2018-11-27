import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { RecursoService } from './lista-recurso/recurso.service';
import { Recurso } from './lista-recurso/models/recurso';
import { DialogoNewRecursoComponent } from './lista-recurso/dialogo-new-recurso/dialogo-new-recurso.component';

@Component({
  selector: 'app-note-list',
  templateUrl: './note-list.component.html',
  styleUrls: ['./note-list.component.css']
})
export class RecursoListComponent implements OnInit {
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
    const dialogoNuevaNota = this.dialog.open(DialogoNewRecursoComponent);

    dialogoNuevaNota.afterClosed().subscribe(result => {
      this.getListaRecurso('Recurso creado');
    });

  }

  eliminarRecurso(element: Recurso) {
    this.snackBar.open(`Eliminando ${element.título}`, 'Cerrar', {
      duration: 3000,
    });
  }

}
