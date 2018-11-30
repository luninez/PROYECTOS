export class RecursoDto {
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
