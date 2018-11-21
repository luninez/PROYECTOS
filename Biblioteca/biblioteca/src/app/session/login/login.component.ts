import { Component, OnInit } from '@angular/core';

// vinculamos con el dto
import { LoginDto } from './login-dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // creamos los atributos del componente(email y contraseña)
  email: string;
  password: string;

  constructor() { }

  ngOnInit() {
  }

  // generamos el metodo encargado de almacenar los datos
  doLogin() {
    const dto = new LoginDto(this.email, this.password);

    // aqui evaluaremos si el usuario es correcto
  }

}
