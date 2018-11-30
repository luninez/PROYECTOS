import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';

import { RecursoService } from './recurso.service';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.scss']
})
export class RecursosComponent implements OnInit {
  displayedColumns: string[] = ['id', 'title', 'autor', 'anyo', 'content', 'type', 'category', 'acciones'];
  dataRecursos;

  constructor(private recursoService: RecursoService) { }

  ngOnInit() {
    this.recursoService.getAllRecurso().subscribe(recursos => {
      this.dataRecursos = new MatTableDataSource(recursos);
    });
  }

  applyFilter(filterValue: string) {
    this.dataRecursos.filter = filterValue.trim().toLowerCase();
  }

}
