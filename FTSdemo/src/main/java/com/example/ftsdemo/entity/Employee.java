package com.example.ftsdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Field can not be empty")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Field can not be empty")
    private String lastName;

    @Column(name = "email")
    @NotEmpty(message = "Field can not be empty")
    @Email(message = "Must be a well-formed email address")
    private String email;
}
