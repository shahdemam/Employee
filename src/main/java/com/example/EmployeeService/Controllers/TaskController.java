package com.example.EmployeeService.Controllers;
import com.example.EmployeeService.DTOS.TaskEmployeeDto;
import com.example.EmployeeService.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TaskEmployeeDto>> GetTasksByEmployeeId(@PathVariable int employeeId) {
        List<TaskEmployeeDto> tasks = taskService.GetTasksByEmployeeId(employeeId);
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/filterEmployee/{employeeId}")
    public ResponseEntity<List<TaskEmployeeDto>> getTasksByEmployeeIdAndStatus(@PathVariable int employeeId, @RequestParam(required = false) String status
    ) {
        List<TaskEmployeeDto> tasks = taskService.getTasksByEmployeeIdAndStatus(employeeId, status);
        return ResponseEntity.ok(tasks);
    }


    @PutMapping("/{taskId}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable int taskId, @RequestParam String status)
    {
        taskService.UpdateTaskStatus(taskId, status);
        return ResponseEntity.ok("Task status updated successfully.");
    }







}
