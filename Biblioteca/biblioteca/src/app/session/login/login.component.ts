import { Component, OnInit } from '@angular/core';

// vinculamos con el dto
import { LoginDto } from './login-dto';

// vinculamos con auth para validar la entrada
import { AuthService } from './Service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  // creamos los atributos del componente(email y contraseña)
  email: string;
  password: string;

  // constructor de la clase
  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  // generamos el metodo encargado de almacenar los datos
  doLogin() {
    const dto = new LoginDto(this.email, this.password);

    // aqui evaluaremos si el usuario es correcto
    this.authService.login(dto).subscribe(loginResp => {
      console.log(loginResp);
      this.authService.setLoginData(loginResp);

    }, error => {
      console.log('Error en petición de login');
    }
    );
  }

}
