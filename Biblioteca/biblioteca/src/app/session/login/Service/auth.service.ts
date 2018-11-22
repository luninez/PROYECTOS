import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginDto } from '../login-dto';
import { Observable } from 'rxjs';
import { LoginResponse } from '../login-response';

const authUrl = `http://www.miguelcamposrivera.com:3002/apibiblioteca/auth/login`;

const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  // login(param1, param2): tipoQueDevuelveElMetodo
  login(loginDto: LoginDto): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${authUrl}/login`, loginDto, requestOptions);
  }

  setLoginData(loginResponse: LoginResponse) {
    localStorage.setItem('token', loginResponse.token);
    localStorage.setItem('username', loginResponse.username);
    localStorage.setItem('email', loginResponse.email);
  }

}
