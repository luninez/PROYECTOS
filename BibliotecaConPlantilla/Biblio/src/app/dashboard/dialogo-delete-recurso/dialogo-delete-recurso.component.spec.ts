import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoDeleteRecursoComponent } from './dialogo-delete-recurso.component';

describe('DialogoDeleteRecursoComponent', () => {
  let component: DialogoDeleteRecursoComponent;
  let fixture: ComponentFixture<DialogoDeleteRecursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogoDeleteRecursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoDeleteRecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
