package com.sofka.hibernatecrud;

import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.model.Project;
import com.sofka.hibernatecrud.model.Role;
import com.sofka.hibernatecrud.repository.IEmployeeJpaRepository;
import com.sofka.hibernatecrud.repository.IProjectJpaRepository;
import com.sofka.hibernatecrud.repository.IRoleJpaRepository;
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

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProject;


    @Test
    public void saveEmployee() {

        Role administrador = new Role("ADMIN");
        Role developer = new Role("DEV");

        administrador = repoRole.save(administrador);
        developer = repoRole.save(developer);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProject.save(proj1);
        proj2 = repoProject.save(proj2);
        proj3 = repoProject.save(proj3);


        Employee john = new Employee("John", "Doe", "empl123", developer);
        Employee claire = new Employee("Claire", "Simpson", "empl124", administrador);


        john.getProjects().add(proj1);
        john.getProjects().add(proj2);
        john.getProjects().add(proj3);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);


        repoEmployee.save(john);
        repoEmployee.save(claire);

        repoEmployee.flush();

        Employee empl123  = repoEmployee.findByEmployeeId("empl123");
        Assertions.assertEquals("John", empl123.getFirstName());
        Assertions.assertEquals(2, repoEmployee.findAll().size());
        Assertions.assertEquals(developer, empl123.getRole());
    }
}
