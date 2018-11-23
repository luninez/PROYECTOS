import { Category } from './category';

export class Recurso {
    id: number;
    título: string;
    autor: string;
    date: Date;
    type: string;
    category: Category;
}
