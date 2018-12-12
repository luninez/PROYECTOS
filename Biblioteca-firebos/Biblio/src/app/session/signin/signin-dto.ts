// El dto es el objeto que almacena los datos que necesitas
// Los unicos datos que deseamos almacenar es el email y la contraseña

export class SigninDto {
    email: string;
    password: string;

    constructor(e: string, p: string) {
        this.email = e;
        this.password = p;
    }
}
