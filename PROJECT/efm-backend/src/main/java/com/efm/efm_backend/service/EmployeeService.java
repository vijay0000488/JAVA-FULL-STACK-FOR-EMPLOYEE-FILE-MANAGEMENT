package com.efm.efm_backend.service;



import com.efm.efm_backend.entity.Employee;
import com.efm.efm_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee saveEmployee(Employee emp) {
        Optional<Employee> existing = employeeRepo.findByEmail(emp.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Employee with email already exists");
        }
        return employeeRepo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
