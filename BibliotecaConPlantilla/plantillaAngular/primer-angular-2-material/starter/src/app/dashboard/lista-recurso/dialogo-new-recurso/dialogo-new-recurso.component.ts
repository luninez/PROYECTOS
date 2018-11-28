import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { RecursoCreateDto } from '../dto/recurso-create.dto';
import { RecursoService } from '../recurso.service';

@Component({
  selector: 'app-dialogo-new-recurso',
  templateUrl: './dialogo-new-recurso.component.html',
  styleUrls: ['./dialogo-new-recurso.component.scss']
})
export class DialogoNewRecursoComponent implements OnInit {
  title: string;
  autor: string;
  anyo: number;
  content: string;
  typeId: number;
  categoryId: number;

  constructor(private recursoService: RecursoService,
    public dialogRef: MatDialogRef<DialogoNewRecursoComponent>) { }

  ngOnInit() {
  }

  addRecurso() {
    const recursoCreateDto = new RecursoCreateDto(this.title, this.autor, this.anyo, this.content, this.typeId, this.categoryId);
    this.recursoService.createRecurso(recursoCreateDto).subscribe(
      recurso => {
        this.dialogRef.close();
      }
    );
  }

}
