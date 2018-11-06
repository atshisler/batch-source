import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrabListOfusersComponent } from './grab-list-ofusers.component';

describe('GrabListOfusersComponent', () => {
  let component: GrabListOfusersComponent;
  let fixture: ComponentFixture<GrabListOfusersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrabListOfusersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrabListOfusersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
