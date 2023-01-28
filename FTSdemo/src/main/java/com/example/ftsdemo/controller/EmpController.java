package com.example.ftsdemo.controller;

import com.example.ftsdemo.entity.Employee;
import com.example.ftsdemo.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model model){
        List<Employee> employeeList = service.getAllEmployees();
        model.addAttribute("employeeList",employeeList);
        return "index";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "form";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        service.saveEmp(employee);
        return "redirect:/";
    }
}
