package com.example.EmployeeService.Models;
import com.example.EmployeeService.Models.Task;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Data
public class Task {
    // ======== Getters and Setters ========
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "employeeId", foreignKey = @ForeignKey(name = "FK_Employee"))
    private User employee;

    @ManyToOne
    @JoinColumn(name = "managerId", foreignKey = @ForeignKey(name = "FK_Manager"))
    private User manager;


}
