import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { RecursoCreateDto } from '../dto/recurso-create.dto';
import { RecursoService } from '../recurso.service';

import { Category } from '../models/category';

@Component({
  selector: 'app-dialogo-new-recurso',
  templateUrl: './dialogo-new-recurso.component.html',
  styleUrls: ['./dialogo-new-recurso.component.scss']
})
export class DialogoNewRecursoComponent implements OnInit {
  id: number;
  título: string;
  autor: string;
  date: Date;
  type: string[] = ['libro', 'revista', 'pelicula'];
  category: Category;

  constructor(private recursoService: RecursoService,
    public dialogRef: MatDialogRef<DialogoNewRecursoComponent>) { }

  ngOnInit() {
  }

  addRecurso() {
    const recursoCreateDto = new RecursoCreateDto(this.título, this.autor, this.date, this.type, this.category);
    this.recursoService.createRecurso(recursoCreateDto).subscribe(
      recurso => {
        this.dialogRef.close();
      }
    );
  }

}
