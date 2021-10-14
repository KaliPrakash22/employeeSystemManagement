import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { UpdateEmployeeComponent } from './update-employee.component';
import { EmployeeService } from '../employee.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('UpdateEmployeeComponent', () => {
  let employeeService :EmployeeService;
  let component: UpdateEmployeeComponent;
  let fixture: ComponentFixture<UpdateEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateEmployeeComponent ],
      imports: [HttpClientTestingModule,RouterTestingModule],
      providers: [EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should have updateEmployee function', () => {
    const service: EmployeeService = TestBed.get(employeeService);
    expect(service.updateEmployee).toBeTruthy();
   });

});
