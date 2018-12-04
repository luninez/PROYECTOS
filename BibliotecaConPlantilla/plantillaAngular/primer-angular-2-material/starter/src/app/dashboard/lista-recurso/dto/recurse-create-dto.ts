export class RecurseCreateDto {
    titulo: string;
    autor: string;
    date: Date;
    type: string;
    category: string;

    constructor(titulo: string, autor: string, date: Date, type: string, category: string) {
        this.titulo = titulo;
        this.autor = autor;
        this.date = date;
        this.type = type;
        this.category = category;
    }
}