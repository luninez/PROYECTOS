export class TypeCreateDto {
    id: number;
    name: string;

    constructor(name: string) {
        this.name = name;
    }
}