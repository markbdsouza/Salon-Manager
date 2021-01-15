import { TestBed } from '@angular/core/testing';

import { CustomerRegisterationService } from './customer-registeration.service';

describe('CustomerRegisterationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerRegisterationService = TestBed.get(CustomerRegisterationService);
    expect(service).toBeTruthy();
  });
});
