import { Category } from '../models/category';

export class RecursoCreateDto {
    id: number;
    título: string;
    autor: string;
    date: Date;
    type: string[];
    category: Category;

    constructor(título: string, autor: string, date: Date, type: string[], category: Category) {
        this.título = título;
        this.autor = autor;
        this.date = date;
        this.type = type;
        this.category = category;
    }
}