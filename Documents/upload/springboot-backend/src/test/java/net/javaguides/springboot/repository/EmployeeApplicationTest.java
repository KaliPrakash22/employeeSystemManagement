package net.javaguides.springboot.repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mindtree.employeemanagerapp.controller.EmployeeController;

//
@ExtendWith(SpringExtension.class)
@SpringBootTest

public class EmployeeApplicationTest {

	@Autowired
    EmployeeController employeeController;
 
    @Test
    public void contextLoads() {
        Assertions.assertThat(employeeController).isNot(null);
    }
}
