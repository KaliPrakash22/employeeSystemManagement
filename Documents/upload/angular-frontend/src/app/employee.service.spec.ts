import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { EmployeeService } from './employee.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('EmployeeService', () => {
  let service: EmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule,RouterTestingModule],
      providers: [EmployeeService]
    });
    service = TestBed.inject(EmployeeService);


  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

});
