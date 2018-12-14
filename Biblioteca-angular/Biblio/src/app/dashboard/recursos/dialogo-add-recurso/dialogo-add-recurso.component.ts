import { Component, OnInit, Type } from '@angular/core';
import { RecursoService } from '../recurso.service';
import { RecursoDto } from '../dto/recursoDto.dto';

import { TypeDto } from '../dto/typeDto.dto';
import { CategoryDto } from '../dto/categoryDto.dto';

import { FormGroup, Validators, FormControl, FormBuilder  } from '@angular/forms';

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

  types: TypeDto[];
  categorias: CategoryDto[];

  public form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private recursoService: RecursoService) { }

  ngOnInit() {
    this.form = this.fb.group ( {
      title: [null , Validators.compose ( [ Validators.required ] )],
      autor: [null , Validators.compose ( [ Validators.required ] )],
      anyo: [null , Validators.compose ( [ Validators.required ] )],
    } );
    this.getListaTipos();
    this.getListaCategorias();
  }

  getListaTipos() {
    this.recursoService.getAllTipos().subscribe(listaTipos => {
      this.types = listaTipos;
    });
  }

  getListaCategorias() {
    this.recursoService.getAllCategorias().subscribe(listaCategorias => {
      this.categorias = listaCategorias;
    });
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
