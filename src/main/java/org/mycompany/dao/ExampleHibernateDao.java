package org.mycompany.dao;

import org.mycompany.dao.repository.*;
import org.mycompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import static org.mycompany.utils.Util.generateRandom;

@Repository
public class ExampleHibernateDao {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    DeptEmpRepository deptEmpRepository;
    @Autowired
    SalariesRepository salariesRepository;
    @Autowired
    TitlesRepository titlesRepository;

    @Autowired
    ContractorsRepository contractorsRepository;

    public void save(){
        String deptNo = UUID.randomUUID().toString();
        Departments departments = Departments.builder()
                .deptNo(deptNo)
                .deptName("CS-" + UUID.randomUUID())
                .build();
        departmentsRepository.save(departments);

        Employees employees = Employees.builder()
                .grade(Employees.GradeEnum.E3)
                .birthDate(new Date(System.currentTimeMillis()))
                .hireDate(new Date(System.currentTimeMillis()))
                .lastName("Srinivasa")
                .firstName("Nagabhushan")
                .build();
        employeesRepository.save(employees);

        DeptEmp deptEmp = DeptEmp.builder()
                .deptNoDepartments(departments)
                .empNoEmployees(employees)
                .fromDate(new Date(System.currentTimeMillis()))
                .toDate(new Date(System.currentTimeMillis()))
                .build();
        employees.setEmpNoDeptEmpSet(Set.of(deptEmp));
        departments.setDeptNoDeptEmpSet(Set.of(deptEmp));
        deptEmpRepository.save(deptEmp);

        Salaries salaries = Salaries.builder()
                .salary(100000)
                .salariesPK(Salaries.SalariesPK.builder()
                        .fromDate(new Date(System.currentTimeMillis()))
                        .build())
                .toDate(new Date(System.currentTimeMillis()))
                .empNoEmployees(employees)
                .build();
        employees.setEmpNoSalariesSet(Set.of(salaries));
        salariesRepository.save(salaries);

        Titles titles = Titles.builder()
                .titlesPK(Titles.TitlesPK.builder()
                        .title("Java")
                        .fromDate(new Date(System.currentTimeMillis()))
                        .build())
                .toDate(new Date(System.currentTimeMillis()))
                .empNoEmployees(employees)
                .build();
        employees.setEmpNoTitlesSet(Set.of(titles));
        titlesRepository.save(titles);

        employees.setDepartments(Set.of(departments));
        departments.setEmployees(Set.of(employees));

        int contractorNo = generateRandom(1,Integer.MAX_VALUE);
        Contractors contractors = Contractors.builder()
                .birthDate(new Date(System.currentTimeMillis()))
                .lastName("S")
                .hireDate(new Date(System.currentTimeMillis()))
                .contractorsPK(Contractors.ContractorsPK.builder()
                        .contractorNo(contractorNo)
                        .firstName("N")
                        .build())
                .build();

        ContractorsSalaries contractorsSalaries = ContractorsSalaries.builder()
                .contractorsSalariesPK(ContractorsSalaries.ContractorsSalariesPK.builder()
                        .salary(100000)
                        .contractorNofirstName(ContractorsSalaries.ContractorNofirstName.builder()
                                .contractorNo(contractorNo)
                                .firstName("Nagabhushan")
                                .build())
                        .build())
                .contractorNofirstNameContractors(contractors)
                .build();

        contractors.setContractorNofirstNameContractorsSalariesSet(Set.of(contractorsSalaries));
        contractorsRepository.save(contractors);

    }
}
