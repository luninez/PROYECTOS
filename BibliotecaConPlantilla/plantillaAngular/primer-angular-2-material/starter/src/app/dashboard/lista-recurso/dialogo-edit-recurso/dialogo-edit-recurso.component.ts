import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Recurso } from '../models/recurso';
import { RecursoService } from '../recurso.service';

@Component({
  selector: 'app-dialogo-edit-recurso',
  templateUrl: './dialogo-edit-recurso.component.html',
  styleUrls: ['./dialogo-edit-recurso.component.scss']
})
export class DialogoEditRecursoComponent implements OnInit {
  recurso: Recurso;
  colorSeleccionado: string;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
  private recursoService: RecursoService,
  public dialogRef: MatDialogRef<DialogoEditRecursoComponent>) { }

  ngOnInit() {
    // Rescatamos el idRecurso que le pasamos al diálogo en su apertura
    const id = this.data.idRecurso;

    this.recursoService.getRecurso(id).subscribe(recurso => {
      this.recurso = recurso;
    });

  }
  saveRecurso() {
    this.recursoService.updateRecurso(this.recurso).subscribe(recurso => {
      this.dialogRef.close();
    });
  }

}
