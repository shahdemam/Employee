package com.example.EmployeeService.DTOS;

import com.example.EmployeeService.Models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class TaskEmployeeDto {

    private String title;
    private String description;
    private String status;
    private Date deadline;

    public TaskEmployeeDto(String title, String description, String status, Date deadline) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }
}
