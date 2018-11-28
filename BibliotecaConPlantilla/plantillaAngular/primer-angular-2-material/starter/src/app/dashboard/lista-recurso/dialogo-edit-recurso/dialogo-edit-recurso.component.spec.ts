import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoEditRecursoComponent } from './dialogo-edit-recurso.component';

describe('DialogoEditRecursoComponent', () => {
  let component: DialogoEditRecursoComponent;
  let fixture: ComponentFixture<DialogoEditRecursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogoEditRecursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoEditRecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
