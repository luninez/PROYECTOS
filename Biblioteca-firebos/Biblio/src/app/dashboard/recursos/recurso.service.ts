import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../../session/signin/Service/auth.service';
import { environment } from 'src/environments/environment';
import { RecursoInterface } from './interfaces/recurso.interface';
import { RecursoDto } from './dto/recursoDto.dto';

const recursoUrl = `${environment.apiUrl}recurso`;

@Injectable({
  providedIn: 'root'
})

export class RecursoService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  getAllRecurso(): Observable<RecursoInterface[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.get<RecursoInterface[]>(`${recursoUrl}/all`, requestOptions);
  }

  getRecurso(idRecurso: number): Observable<RecursoInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.get<RecursoInterface>(`${recursoUrl}/${idRecurso}`, requestOptions);
  }

  createRecurso(recursoCreateDto: RecursoDto): Observable<RecursoInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.post<RecursoInterface>(`${recursoUrl}/create`, recursoCreateDto, requestOptions);
  }

  updateRecurso(recurso: RecursoInterface): Observable<RecursoInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.put<RecursoInterface>(`${recursoUrl}`, recurso, requestOptions);
  }

}
