import { Injectable } from '@angular/core';
import { RecursoCreateDto } from './dto/recurso-create.dto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RecursoCreateResponse } from './interfaces/recurso-create-response';
import { Observable } from 'rxjs';
import { AuthService } from '../../session/signin/Service/auth.service';
import { Recurso } from './models/recurso';

const recursoUrl = `http://www.miguelcamposrivera.com:3002/apibiblioteca/recurso/all`;

@Injectable({
  providedIn: 'root'
})
export class RecursoService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  createRecurso(recursoCreateDto: RecursoCreateDto): Observable<RecursoCreateResponse> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.post<RecursoCreateResponse>(`${recursoUrl}/create`, recursoCreateDto, requestOptions);
  }

  getAllRecurso(): Observable<Recurso[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.get<Recurso[]>(`${recursoUrl}/myrecursos`, requestOptions);
  }
}
