export class CategoryCreateDto {
    id: number;
    name: string;

    constructor(name: string) {
        this.name = name;
    }
}