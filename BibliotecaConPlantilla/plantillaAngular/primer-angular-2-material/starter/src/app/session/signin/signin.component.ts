import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

// vinculamos con el dto
import { SigninDto } from './signin-dto';

// vinculamos con auth para validar la entrada
import { AuthService } from './Service/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  // creamos los atributos del componente(email y contraseña)
  email: string;
  password: string;

  public form: FormGroup;
  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.form = this.fb.group ( {
      uname: [null , Validators.compose ( [ Validators.required ] )] , password: [null , Validators.compose ( [ Validators.required ] )]
    } );
  }

  onSubmit() {
    this.router.navigate ( [ '/dashboard' ] );
  }

  // generamos el metodo encargado de almacenar los datos
  doLogin() {
    const dto = new SigninDto(this.email, this.password);

    // aqui evaluaremos si el usuario es correcto
    this.authService.signin(dto).subscribe(signinResp => {
      console.log(signinResp);
      this.authService.setSigninData(signinResp);

    }, error => {
      console.log('Error en petición de login');
    }
    );
  }

}
