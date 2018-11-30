import { Category } from '../models/category';
import { Type } from '@angular/compiler/src/core';

export class RecursoCreateDto {
    title: string;
    autor: string;
    anyo: number;
    content: string;
    typeId: number;
    categoryId: number;

    constructor(title: string, autor: string, anyo: number, content: string, typeId: number, categoryId: number) {
        this.title = title;
        this.autor = autor;
        this.anyo = anyo;
        this.content = content;
        this.typeId = typeId;
        this.categoryId = categoryId;
    }
}
