package net.javaguides.springboot.repository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.mindtree.employeemanagerapp.controller.EmployeeController;
import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@MockBean
	EmployeeService employeeService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testfindAll() throws Exception {
		Employee employee = new Employee("Kali", "prakash" ,"kprakash@gmail.com");
		Employee employee2 = new Employee("Krishn", "saxena" ,"krishn@gmail.com");
		Employee employee3 = new Employee("raunak", "raj" ,"raunak@gmail.com");
		Employee employee4 = new Employee("raj", "Giri" ,"raj@gmail.com");
		List<Employee> employees = Arrays.asList(employee,employee2,employee3,employee4);

		Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

		mockMvc.perform(get("/api/v1/employees"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(4)))
				.andExpect(jsonPath("$[0].firstName", Matchers.is("Kali")))
				.andExpect(jsonPath("$[1].firstName", Matchers.is("Krishn")))
				.andExpect(jsonPath("$[2].firstName", Matchers.is("raunak")))
				.andExpect(jsonPath("$[3].firstName", Matchers.is("raj")))
				;
	}

}
