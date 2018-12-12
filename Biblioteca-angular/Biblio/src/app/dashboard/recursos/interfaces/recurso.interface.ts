import { CategoryInterface } from './category.interface';
import { TypeInterface } from './type.interface';

export interface RecursoInterface {
    id: number;
    title: string;
    autor: string;
    anyo: number;
    content: string;
    free: boolean;
    category: CategoryInterface;
    type: TypeInterface;
}
