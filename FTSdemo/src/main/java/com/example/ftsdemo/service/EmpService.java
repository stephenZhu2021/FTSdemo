package com.example.ftsdemo.service;

import com.example.ftsdemo.entity.Employee;
import com.example.ftsdemo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository repository;

    public void saveEmp(Employee employee){
        repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
}
