import { Component, OnInit, Inject } from '@angular/core';
import { RecursoInterface } from '../interfaces/recurso.interface';
import { RecursoService } from '../recurso.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TypeInterface } from '../interfaces/type.interface';
import { CategoryInterface } from '../interfaces/category.interface';

@Component({
  selector: 'app-dialogo-edit-recurso',
  templateUrl: './dialogo-edit-recurso.component.html',
  styleUrls: ['./dialogo-edit-recurso.component.scss']
})
export class DialogoEditRecursoComponent implements OnInit {
  recurso: RecursoInterface;
  tipoSeleccionado: TypeInterface;
  categoriaSeleccionada: CategoryInterface;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
  private recursoService: RecursoService,
  public dialogRef: MatDialogRef<DialogoEditRecursoComponent>) { }

  ngOnInit() {
    // Rescatamos el idRecurso que le pasamos al diálogo en su apertura
    const id = this.data.idRecurso;

    this.recursoService.getRecurso(id).subscribe(recurso => {
      this.recurso = recurso;
      this.tipoSeleccionado = this.recurso.type;
      this.categoriaSeleccionada = this.recurso.category;
    });

  }
  saveRecurso() {
    this.recursoService.updateRecurso(this.recurso).subscribe(recurso => {
      this.dialogRef.close();
    });
  }

}
