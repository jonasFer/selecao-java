import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricoFormComponent } from './historico-form.component';

describe('HistoricoFormComponent', () => {
  let component: HistoricoFormComponent;
  let fixture: ComponentFixture<HistoricoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistoricoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoricoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
