import { Component, OnInit, Inject } from '@angular/core';
import { CategoryDto } from '../../dto/categoryDto.dto';
import { MatSnackBar, MAT_DIALOG_DATA } from '@angular/material';
import { AuthService } from 'src/app/session/signin/Service/auth.service';

@Component({
  selector: 'app-dialogo-delete-categoria',
  templateUrl: './dialogo-delete-categoria.component.html',
  styleUrls: ['./dialogo-delete-categoria.component.scss']
})
export class DialogoDeleteCategoriaComponent implements OnInit {
  name: string;
  categoriaEliminar: CategoryDto;

  constructor(public snackBar: MatSnackBar, private authService: AuthService,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.categoriaEliminar = this.data.recurso;
  }

  correcto() {
    return this.name === 'eliminar';
  }

  eliminarCategoria() {
    this.snackBar.open(`Eliminando ${this.categoriaEliminar.name}`, 'Cerrar', {
      duration: 3000,
    });
  }
}
