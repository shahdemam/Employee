package com.example.EmployeeService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeService.Models.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTaskByEmployeeIdAndStatus(int employeeId, String status);
    List<Task> findTasksByEmployeeId(int employeeId);

}
