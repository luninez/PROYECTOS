import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoAddRecursoComponent } from './dialogo-add-recurso.component';

describe('DialogoAddRecursoComponent', () => {
  let component: DialogoAddRecursoComponent;
  let fixture: ComponentFixture<DialogoAddRecursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogoAddRecursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoAddRecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
