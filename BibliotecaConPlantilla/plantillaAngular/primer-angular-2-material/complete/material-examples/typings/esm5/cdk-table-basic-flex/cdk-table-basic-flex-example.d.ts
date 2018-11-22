import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
/**
 * @title Basic use of `<cdk-table>` (uses display flex)
 */
export declare class CdkTableBasicFlexExample {
    displayedColumns: string[];
    dataSource: ExampleDataSource;
}
export interface PeriodicElement {
    name: string;
    position: number;
    weight: number;
    symbol: string;
}
/**
 * Data source to provide what data should be rendered in the table. Note that the data source
 * can retrieve its data in any way. In this case, the data source is provided a reference
 * to a common data base, ExampleDatabase. It is not the data source's responsibility to manage
 * the underlying data. Instead, it only needs to take the data and send the table exactly what
 * should be rendered.
 */
export declare class ExampleDataSource extends DataSource<PeriodicElement> {
    /** Stream of data that is provided to the table. */
    data: BehaviorSubject<PeriodicElement[]>;
    /** Connect function called by the table to retrieve one stream containing the data to render. */
    connect(): Observable<PeriodicElement[]>;
    disconnect(): void;
}
