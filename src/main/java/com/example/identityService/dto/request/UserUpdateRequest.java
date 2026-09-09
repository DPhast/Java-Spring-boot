package com.example.identityService.dto.request;

import com.example.identityService.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @Size(min = 8, message = "Password must be at least 8 characters")
     String password;

     String firstName;
     String lastName;

     @DobConstraint(min = 18, message = "Invalid date of birth")
     LocalDate dob;
     List<String> roles;
}
