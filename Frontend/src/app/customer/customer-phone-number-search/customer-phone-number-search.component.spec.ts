import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPhoneNumberSearchComponent } from './customer-phone-number-search.component';

describe('CustomerPhoneNumberSearchComponent', () => {
  let component: CustomerPhoneNumberSearchComponent;
  let fixture: ComponentFixture<CustomerPhoneNumberSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerPhoneNumberSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerPhoneNumberSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
