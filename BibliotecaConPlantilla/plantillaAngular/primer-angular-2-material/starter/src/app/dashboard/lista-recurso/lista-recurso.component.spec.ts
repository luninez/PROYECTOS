import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaRecursoComponent } from './lista-recurso.component';

describe('ListaRecursoComponent', () => {
  let component: ListaRecursoComponent;
  let fixture: ComponentFixture<ListaRecursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaRecursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaRecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
