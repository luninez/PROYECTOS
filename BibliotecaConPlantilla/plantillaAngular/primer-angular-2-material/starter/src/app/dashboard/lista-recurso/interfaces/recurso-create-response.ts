import { Category } from '../models/category';

export interface RecursoCreateResponse {
    id: number;
    título: string;
    autor: string;
    date: Date;
    type: string[];
    category: Category;
}
