package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Transactional
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        softwareMachine.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(lindaKovalsky);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaesterId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaesterId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(dataMaesterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void findEmployeeByLastname(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        int johnSmithId = johnSmith.getId();
        int stephanieClarcksonId = stephanieClarckson.getId();
        int lindaKovalskyId = lindaKovalsky.getId();

        Employee smith = employeeDao.findByLastname("Smith");
        Employee clarckson = employeeDao.findByLastname("Clarckson");
        Employee kovalsky = employeeDao.findByLastname("Kovalsky");

        //Then
        try {
            assertEquals("Smith", smith.getLastname());
            assertEquals("Clarckson", clarckson.getLastname());
            assertEquals("Kovalsky", kovalsky.getLastname());
        } finally {
            //CleanUp
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
        }
    }

    @Test
    void findCompanyByFirstThreeCharacters(){
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        int softwareMachineId = softwareMachine.getId();
        int dataMaesterId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();

        List<Company> softwareMachinePrefix = companyDao.findByFirstThreeCharacters("Sof");
        List<Company> dataMaesterPrefix = companyDao.findByFirstThreeCharacters("Dat");
        List<Company> greyMatterPrefix = companyDao.findByFirstThreeCharacters("Gre");

        //Then
        try{
            assertEquals("Software Machine", softwareMachinePrefix.get(0).getName());
            assertEquals("Data Maesters", dataMaesterPrefix.get(0).getName());
            assertEquals("Grey Matter", greyMatterPrefix.get(0).getName());
        } finally {
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaesterId);
            companyDao.deleteById(greyMatterId);
        }
    }
}
