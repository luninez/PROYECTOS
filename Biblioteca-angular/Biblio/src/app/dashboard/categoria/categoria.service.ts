import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../../session/signin/Service/auth.service';
import { environment } from 'src/environments/environment';
import { CategoryInterface } from '../interfaces/category.interface';
import { CategoryDto } from '../dto/categoryDto.dto';

const categoriaUrl = `${environment.apiUrl}categoria`;

@Injectable({
  providedIn: 'root'
})

export class CategoriaService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  getAllCategorias(): Observable<CategoryInterface[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.get<CategoryInterface[]>(`${categoriaUrl}/all`, requestOptions);
  }

  getCategory(idCategory: number): Observable<CategoryInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.get<CategoryInterface>(`${categoriaUrl}/${idCategory}`, requestOptions);
  }

  createCategoria(categoriaCreateDto: CategoryDto): Observable<CategoryInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.post<CategoryInterface>(`${categoriaUrl}/create`, categoriaCreateDto, requestOptions);
  }

  updateCategoria(categoria: CategoryInterface): Observable<CategoryInterface> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.put<CategoryInterface>(`${categoriaUrl}`, categoria, requestOptions);
  }

  eliminarCategoria() {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      })
    };

    return this.http.delete<CategoryInterface[]>(`${categoriaUrl}/delete`, requestOptions);
  }

}
