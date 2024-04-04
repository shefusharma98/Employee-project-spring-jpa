package com.example.Employeespringproject.service;

import com.example.Employeespringproject.model.Employee;
import com.example.Employeespringproject.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;


    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Optional<Employee> getEmployee(int id) {
        return repo.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void loadData(){
        List<Employee> employees = new ArrayList<>(List.of(new Employee(101,"Deepak","Manager"),
                new Employee(102,"Shefali","Supervisor")));

       repo.saveAll(employees);
    }

    public void updateEmployee(Employee employee) {
        repo.save(employee);
    }


    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
