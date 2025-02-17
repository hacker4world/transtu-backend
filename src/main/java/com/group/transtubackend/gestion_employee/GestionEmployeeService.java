package com.group.transtubackend.gestion_employee;

import com.group.transtubackend.authentication.dto.ApiResponse;
import com.group.transtubackend.authentication.dto.LoginDto;
import com.group.transtubackend.authentication.dto.LoginResponseDto;
import com.group.transtubackend.authentication.entities.Departement;
import com.group.transtubackend.authentication.entities.User;
import com.group.transtubackend.authentication.repositories.DepartementRepository;
import com.group.transtubackend.authentication.repositories.UserRepository;
import com.group.transtubackend.gestion_employee.dto.CreateEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GestionEmployeeService {
    private final UserRepository userRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public GestionEmployeeService(UserRepository userRepository, DepartementRepository departementRepository) {
        this.userRepository = userRepository;
        this.departementRepository = departementRepository;
    }

    public ResponseEntity<ApiResponse<List<LoginResponseDto>>> getAllEmployees(int departmentId) {
        Optional<Departement> departement = departementRepository.findById(departmentId);

        if (departement.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Department not found", null));
        }

        List<User> users = userRepository.findAllByDepartement(departement.get());

        List<LoginResponseDto> loginDtos = new ArrayList<>();

        for (User user : users) {
            loginDtos.add(LoginResponseDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .departmentName(user.getDepartement().getName())
                    .departmentId(user.getDepartement().getId())
                    .build());
        }

        return ResponseEntity.ok(new ApiResponse<>("Employees retrieved successfully", loginDtos));

    }

    public ResponseEntity<ApiResponse<LoginResponseDto>> createEmployee(CreateEmployeeDto employeeData) {
        Optional<User> user = userRepository.findByEmail(employeeData.getEmail());

        if (user.isPresent()) {
            return ResponseEntity.status(400).body(new ApiResponse<>("User already exists", null));
        }

        Optional<Departement> departement = departementRepository.findById(employeeData.getDepartementId());

        if (departement.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Department not found", null));
        }

        User newUser = User.builder()
                .firstName(employeeData.getFirstName())
                .lastName(employeeData.getLastName())
                .email(employeeData.getEmail())
                .role("employee")
                .departement(departement.get())
                .build();

        userRepository.save(newUser);

        LoginResponseDto loginDto = LoginResponseDto.builder()
                .id(newUser.getId())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .departmentName(newUser.getDepartement().getName())
                .departmentId(newUser.getDepartement().getId())
                .build();

        return ResponseEntity.ok(new ApiResponse<>("Employee created successfully", loginDto));
    }

    public ResponseEntity<ApiResponse<String>> deleteEmployee(int employeeId) {
        Optional<User> user = userRepository.findById(employeeId);

        if (user.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("User not found", null));
        }

        userRepository.delete(user.get());

        return ResponseEntity.ok(new ApiResponse<>("Employee deleted successfully", null));
    }

}
