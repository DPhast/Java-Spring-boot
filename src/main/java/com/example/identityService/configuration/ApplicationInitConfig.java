package com.example.identityService.configuration;


import com.example.identityService.entity.User;
import com.example.identityService.entity.Role;
import com.example.identityService.repository.RoleRepository;
import com.example.identityService.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            if (roleRepository.findById("USER").isEmpty()) {
                roleRepository.save(
                        Role.builder()
                                .name("USER")
                                .description("User role")
                                .build()
                );
            }

            if (roleRepository.findById("ADMIN").isEmpty()) {
                roleRepository.save(
                        Role.builder()
                                .name("ADMIN")
                                .description("Admin role")
                                .build()
                );
            }

            if (userRepository.findByUsername("admin").isEmpty()) {

                Role adminRole = roleRepository.findById("ADMIN")
                        .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));

                var roles = new HashSet<Role>();
                roles.add(adminRole);

                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(roles)
                        .build();

                userRepository.save(user);
            }
        };
    };
}
