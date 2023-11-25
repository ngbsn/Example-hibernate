package org.mycompany.dao;

import org.mycompany.dao.repository.DepartmentsRepository;
import org.mycompany.dao.repository.EmployeesRepository;
import org.mycompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Set;

@Repository
public class ExampleHibernateDao {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    public void save(){
        Departments departments = Departments.builder()
                .deptNo("100")
                .deptName("CS")
                .build();
        Employees employees = Employees.builder()
                .empNo(1)
                .grade(Employees.GradeEnum.E3)
                .birthDate(new Date(System.currentTimeMillis()))
                .hireDate(new Date(System.currentTimeMillis()))
                .lastName("Srinivasa")
                .firstName("Nagabhushan")
                .build();

        DeptEmp deptEmp = DeptEmp.builder()
                .deptNoDepartments(departments)
                .empNoEmployees(employees)
                .fromDate(new Date(System.currentTimeMillis()))
                .toDate(new Date(System.currentTimeMillis()))
                .build();

        Salaries salaries = Salaries.builder()
                .salary(100000)
                .salariesPK(Salaries.SalariesPK.builder()
                        .fromDate(new Date(System.currentTimeMillis()))
                        .build())
                .toDate(new Date(System.currentTimeMillis()))
                .empNoEmployees(employees)
                .build();

        Titles titles = Titles.builder()
                .titlesPK(Titles.TitlesPK.builder()
                        .title("Java")
                        .fromDate(new Date(System.currentTimeMillis()))
                        .build())
                .toDate(new Date(System.currentTimeMillis()))
                .empNoEmployees(employees)
                .build();

        employees.setEmpNoDeptEmpSet(Set.of(deptEmp));
        departments.setDeptNoDeptEmpSet(Set.of(deptEmp));

        employees.setEmpNoSalariesSet(Set.of(salaries));
        employees.setEmpNoTitlesSet(Set.of(titles));

        employees.setDepartments(Set.of(departments));
        departments.setEmployees(Set.of(employees));

        employeesRepository.save(employees);
        departmentsRepository.save(departments);

        Contractors contractors = Contractors.builder()
                .birthDate(new Date(System.currentTimeMillis()))
                .lastName("Srinivasa")
                .hireDate(new Date(System.currentTimeMillis()))
                .contractorsPK(Contractors.ContractorsPK.builder()
                        .contractorNo(1)
                        .firstName("Nagabhushan")
                        .build())
                .build();

        ContractorsSalaries contractorsSalaries = ContractorsSalaries.builder()
                .contractorsSalariesPK(ContractorsSalaries.ContractorsSalariesPK.builder()
                        .salary(100000)
                        .contractorNofirstName(ContractorsSalaries.ContractorNofirstName.builder()
                                .contractorNo(1)
                                .firstName("Nagabhushan")
                                .build())
                        .build())
                .contractorNofirstNameContractors(contractors)
                .build();

        contractors.setContractorNofirstNameContractorsSalariesSet(Set.of(contractorsSalaries));

    }
}
