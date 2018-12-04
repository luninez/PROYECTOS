import { Component, OnInit, Type } from '@angular/core';
import { RecursoService } from '../recurso.service';
import { RecursoDto } from '../dto/recursoDto.dto';

@Component({
  selector: 'app-dialogo-add-recurso',
  templateUrl: './dialogo-add-recurso.component.html',
  styleUrls: ['./dialogo-add-recurso.component.scss']
})
export class DialogoAddRecursoComponent implements OnInit {
  title: string;
  autor: string;
  anyo: number;
  url: string;
  content: string;
  typeId: number;
  categoryId: number;

  constructor(private recursoService: RecursoService) { }

  ngOnInit() {
  }

  addRecurso() {
    const recursoDto = new RecursoDto(this.title, this.autor, this.anyo, this.url, this.content, this.typeId, this.categoryId);
    this.recursoService.createRecurso(recursoDto).subscribe(
      recurso => {
        console.log(recurso);
      }
    );
  }

}
