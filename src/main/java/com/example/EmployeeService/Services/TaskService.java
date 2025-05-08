package com.example.EmployeeService.Services;

import com.example.EmployeeService.DTOS.TaskEmployeeDto;
import com.example.EmployeeService.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeService.Models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List<TaskEmployeeDto> GetTasksByEmployeeId(int id)
    {
        List<Task> tasks = taskRepository.findTasksByEmployeeId(id);

        return tasks.stream()
                .map(task -> new TaskEmployeeDto(
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getDeadline()
                ))
                .collect(Collectors.toList());
    }

    public List<TaskEmployeeDto> getTasksByEmployeeIdAndStatus(int employeeId, String status) {
        List<Task> tasks;
        if (status != null && !status.isEmpty()) {
            tasks = taskRepository.findTaskByEmployeeIdAndStatus(employeeId, status);
        } else {
            tasks = taskRepository.findTasksByEmployeeId(employeeId);
        }
        return tasks.stream()
                .map(task -> new TaskEmployeeDto(
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getDeadline()
                ))
                .collect(Collectors.toList());
    }

    public void UpdateTaskStatus(int taskId, String status)
    {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        taskRepository.save(task);
    }








}
