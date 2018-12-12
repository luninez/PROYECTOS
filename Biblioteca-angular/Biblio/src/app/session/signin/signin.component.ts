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

  public form: FormGroup;
  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.form = this.fb.group ( {
      email: [null , Validators.compose ( [ Validators.required ] )],
      password: [null , Validators.compose ( [ Validators.required ] )]
    } );
  }

  // generamos el metodo encargado de enviar los datos de login al servicio
  // COMPONENTE (coge datos del formulario) >>>> SERVICIO (envía datos al servidor)
  doLogin() {
    const dto = new SigninDto(this.form.controls['email'].value, this.form.controls['password'].value);
    console.log(dto);
    // invocamos al método 'signin' del 'authService' para que envíe los datos de login
    // al servidor de la API.
    this.authService.signin(dto).subscribe(signinResp => {
      console.log(signinResp);
      this.authService.setSigninData(signinResp);
      this.router.navigate ( [ '/dashboard' ] );

    }, error => {
      console.log('Error en petición de login');
    }
    );
  }

}
