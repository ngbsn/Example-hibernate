package org.mycompany.mysql.dao;

import org.mycompany.mysql.dao.repository.*;
import org.mycompany.mysql.models.*;
import org.mycompany.mysql.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Repository
public class MySQLHibernateDao {

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
    @Autowired
    ContractorsSalariesRepository contractorsSalariesRepository;
    @Autowired
    ContractorsRolesRepository contractorsRolesRepository;

    public void save(){
        String deptNo = UUID.randomUUID().toString();
        Departments departments = Departments.builder()
                .deptNo(deptNo)
                .deptName("CS-" + UUID.randomUUID())
                .build();
        departments = departmentsRepository.save(departments);

        Employees employees = Employees.builder()
                .grade(Employees.GradeEnum.E3)
                .birthDate(new Date(System.currentTimeMillis()))
                .hireDate(new Date(System.currentTimeMillis()))
                .lastName("Srinivasa")
                .firstName("Nagabhushan")
                .build();
        employees = employeesRepository.save(employees);

        DeptEmp deptEmp = DeptEmp.builder()
                .deptEmpPK(DeptEmp.DeptEmpPK.builder()
                        .empNo(employees.getEmpNo())
                        .deptNo(departments.getDeptNo())
                        .build())
                .empNoEmployees(employees)
                .deptNoDepartments(departments)
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
        employeesRepository.save(employees);


        int contractorNo = Util.generateRandom(1,Integer.MAX_VALUE);
        Contractors.ContractorsPK contractorsPK = Contractors.ContractorsPK.builder()
                .contractorNo(contractorNo)
                .firstName("N")
                .build();
        Contractors contractors = Contractors.builder()
                .birthDate(new Date(System.currentTimeMillis()))
                .lastName("S")
                .hireDate(new Date(System.currentTimeMillis()))
                .contractorsPK(contractorsPK)
                .build();
        contractors = contractorsRepository.save(contractors);

        ContractorsSalaries contractorsSalaries = ContractorsSalaries.builder()
                .contractorsSalariesPK(ContractorsSalaries.ContractorsSalariesPK.builder()
                        .salary(100000)
                        .contractorsPK(contractorsPK)
                        .build())
                .contractorNofirstNameContractors(contractors)
                .build();

        contractors.setContractorNofirstNameContractorsSalariesSet(Set.of(contractorsSalaries));
        contractorsSalariesRepository.save(contractorsSalaries);

        ContractorsRoles contractorsRoles = ContractorsRoles.builder()
                .role("Developer")
                .contractorsPK(contractorsPK)
                .contractorNofirstNameContractors(contractors)
                .build();

        contractors.setContractorNofirstNameContractorsRolesSet(Set.of(contractorsRoles));
        contractorsRolesRepository.save(contractorsRoles);

    }
}
