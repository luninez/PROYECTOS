import { Component, OnInit, Type } from '@angular/core';
import { RecursoService } from '../recurso.service';
import { RecursoDto } from '../dto/recursoDto.dto';
import { CategoryDto } from '../dto/categoryDto.dto';
import { TypeDto } from '../dto/typeDto.dto';
import { TypeInterface } from '../interfaces/type.interface';
import { CategoryInterface } from '../interfaces/category.interface';

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
  type: TypeInterface;
  category: CategoryInterface;

  constructor(private recursoService: RecursoService) { }

  ngOnInit() {
  }

  addRecurso() {
    const recursoDto = new RecursoDto(this.title, this.autor, this.anyo, this.url, this.content, this.type, this.category);
    this.recursoService.createRecurso(recursoDto).subscribe(
      recurso => {
        console.log(recurso);
      }
    );
  }

}
