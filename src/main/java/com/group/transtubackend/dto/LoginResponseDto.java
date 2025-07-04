package com.group.transtubackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String departmentName;
    private int departmentId;
    private int agentId;
}
