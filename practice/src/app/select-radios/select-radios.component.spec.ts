import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectRadiosComponent } from './select-radios.component';

describe('SelectRadiosComponent', () => {
  let component: SelectRadiosComponent;
  let fixture: ComponentFixture<SelectRadiosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectRadiosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectRadiosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
