import { Component, OnInit } from '@angular/core';
import { RecursoService } from '../recurso.service';
import { RecursoCreateDto } from '../dto/recurso-create.dto';

@Component({
  selector: 'app-dialogo-add-recurso',
  templateUrl: './dialogo-add-recurso.component.html',
  styleUrls: ['./dialogo-add-recurso.component.scss']
})
export class DialogoAddRecursoComponent implements OnInit {

  title: string;
  autor: string;
  anyo: number;
  content: string;
  typeId: number;
  categoryId: number;

  constructor(private recursoService: RecursoService) { }

  ngOnInit() {
  }

  addRecurso() {
    const recurseCreateDto = new RecursoCreateDto(this.title, this.autor, this.anyo, this.content, this.typeId, this.categoryId);
    this.recursoService.createRecurso(recurseCreateDto).subscribe(
      recurso => {
        console.log(recurso);
      }
    );
  }

}
