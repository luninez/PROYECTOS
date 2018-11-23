import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SigninDto } from '../signin-dto';
import { Observable } from 'rxjs';
import { SigninResponse } from '../signin-response';

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

  // signin(param1, param2): tipoQueDevuelveElMetodo
  signin(signinDto: SigninDto): Observable<SigninResponse> {
    return this.http.post<SigninResponse>(`${authUrl}`, signinDto, requestOptions);
  }

  setSigninData(signinResponse: SigninResponse) {
    localStorage.setItem('token', signinResponse.token);
    localStorage.setItem('username', signinResponse.username);
    localStorage.setItem('email', signinResponse.email);
    localStorage.setItem('role', signinResponse.role);
  }

}
