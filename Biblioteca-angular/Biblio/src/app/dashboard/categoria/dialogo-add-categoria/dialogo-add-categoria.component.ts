import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CategoriaService } from '../categoria.service';
import { CategoryDto } from '../../dto/categoryDto.dto';

@Component({
  selector: 'app-dialogo-add-categoria',
  templateUrl: './dialogo-add-categoria.component.html',
  styleUrls: ['./dialogo-add-categoria.component.scss']
})
export class DialogoAddCategoriaComponent implements OnInit {
  name: string;

  public form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private categoriaService: CategoriaService) { }

  ngOnInit() {
    this.form = this.fb.group ( {
      title: [null , Validators.compose ( [ Validators.required ] )],
      autor: [null , Validators.compose ( [ Validators.required ] )],
      anyo: [null , Validators.compose ( [ Validators.required ] )],
    } );
  }

  addCategoria() {
    const categoryDto = new CategoryDto(this.name);
    this.categoriaService.createCategoria(categoryDto).subscribe(
      categoria => {
        console.log(categoria);
      }
    );
  }
}
