import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RecursoDto } from '../dto/recursoDto.dto';

import { AuthService } from '../../../session/signin/Service/auth.service';

@Component({
  selector: 'app-dialogo-delete-recurso',
  templateUrl: './dialogo-delete-recurso.component.html',
  styleUrls: ['./dialogo-delete-recurso.component.scss']
})
export class DialogoDeleteRecursoComponent implements OnInit {

  constructor(public snackBar: MatSnackBar, private authService: AuthService) { }

  ngOnInit() {
  }

  correcto() {
    return localStorage.getItem('eliminar') === 'eliminar';
  }

  isAdmin() {
    return this.authService.isAdmin();
  }

  eliminarRecurso(element: RecursoDto) {
    this.snackBar.open(`Eliminando ${element.title}`, 'Cerrar', {
      duration: 3000,
    });
  }

}
