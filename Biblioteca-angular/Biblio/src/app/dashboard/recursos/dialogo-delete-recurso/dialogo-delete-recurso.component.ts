import { Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RecursoDto } from '../dto/recursoDto.dto';

import { AuthService } from '../../../session/signin/Service/auth.service';
import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-dialogo-delete-recurso',
  templateUrl: './dialogo-delete-recurso.component.html',
  styleUrls: ['./dialogo-delete-recurso.component.scss']
})
export class DialogoDeleteRecursoComponent implements OnInit {
  title: string;
  recursoEliminar: RecursoDto;

  constructor(public snackBar: MatSnackBar, private authService: AuthService,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.recursoEliminar = this.data.recurso;
  }

  correcto() {
    return this.title === 'eliminar';
  }

  eliminarRecurso() {
    this.snackBar.open(`Eliminando ${this.recursoEliminar.title}`, 'Cerrar', {
      duration: 3000,
    });
  }

}
