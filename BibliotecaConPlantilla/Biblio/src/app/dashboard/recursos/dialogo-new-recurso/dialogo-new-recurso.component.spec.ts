import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoNewRecursoComponent } from './dialogo-new-recurso.component';

describe('DialogoNewRecursoComponent', () => {
  let component: DialogoNewRecursoComponent;
  let fixture: ComponentFixture<DialogoNewRecursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogoNewRecursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoNewRecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
