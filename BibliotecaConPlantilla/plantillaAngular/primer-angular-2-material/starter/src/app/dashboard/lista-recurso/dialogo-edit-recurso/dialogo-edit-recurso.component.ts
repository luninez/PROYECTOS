import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Recurso } from '../models/recurso';
import { RecursoService } from '../recurso.service';

@Component({
  selector: 'app-dialog-edit-recurso',
  templateUrl: './dialog-edit-recurso.component.html',
  styleUrls: ['./dialog-edit-recurso.component.css']
})
export class DialogEditRecursoComponent implements OnInit {
  recurso: Recurso;
  colorSeleccionado: string;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
  private noteService: RecursoService,
  public dialogRef: MatDialogRef<DialogEditRecursoComponent>) { }

  ngOnInit() {
    // Rescatamos el idNota que le pasamos al diálogo en su apertura
    const id = this.data.idNota;

    this.recursoService.getRecurso(id).subscribe(nota => {
      this.nota = nota;
      this.colorSeleccionado = this.nota.color;
    });

  }
  saveNote() {
    this.noteService.updateNota(this.nota).subscribe(nota => {
      this.dialogRef.close();
    });
  }

}
