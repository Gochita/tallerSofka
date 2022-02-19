package com.sofka.hibernatecrud;

import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.repository.IEmployeeJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaRepositoryTest {

    @Autowired
    private IEmployeeJpaRepository repoEmployee;


    @Test
    public void saveEmployee(){



        Employee john = new Employee("John", "Doe", "empl123");
        Employee claire = new Employee("Claire", "Simpson", "empl124");


        repoEmployee.save(john);
        repoEmployee.save(claire);

        repoEmployee.flush();

        Assertions.assertEquals(2, repoEmployee.findAll().size());
    }
}
