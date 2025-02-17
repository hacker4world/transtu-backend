package com.group.transtubackend.gestion_employee;

import com.group.transtubackend.authentication.dto.ApiResponse;
import com.group.transtubackend.authentication.dto.LoginResponseDto;
import com.group.transtubackend.gestion_employee.dto.CreateEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class GestionEmployeeController {
    private final GestionEmployeeService gestionEmployeeService;

    @Autowired
    public GestionEmployeeController(GestionEmployeeService gestionEmployeeService) {
        this.gestionEmployeeService = gestionEmployeeService;
    }

    @GetMapping("/all/{departmentId}")
    public ResponseEntity<ApiResponse<List<LoginResponseDto>>> getAllEmployees(@PathVariable int departmentId) {
        return gestionEmployeeService.getAllEmployees(departmentId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<LoginResponseDto>> createEmployee(@RequestBody CreateEmployeeDto employeeData) {
        return gestionEmployeeService.createEmployee(employeeData);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable int employeeId) {
        return gestionEmployeeService.deleteEmployee(employeeId);
    }
}
