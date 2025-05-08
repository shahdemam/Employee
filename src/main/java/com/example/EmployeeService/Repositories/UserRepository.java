package com.example.EmployeeService.Repositories;

import com.example.EmployeeService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

