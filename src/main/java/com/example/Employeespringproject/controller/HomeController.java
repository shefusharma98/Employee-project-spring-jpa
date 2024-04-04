package com.example.Employeespringproject.controller;

import com.example.Employeespringproject.model.Employee;
import com.example.Employeespringproject.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private EmpService service;

    @GetMapping("getEmployees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }

    @PostMapping("addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }


    @GetMapping("load")
    public String loadData(){
        service.loadData();
        return "success";
    }


    @PutMapping("update")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
        return service.getEmployee(employee.getId());
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return "deleted";
    }
}
