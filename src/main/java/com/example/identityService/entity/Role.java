package com.example.identityService.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @EqualsAndHashCode.Include
    String name;

    String description;

    @ManyToMany
    Set<Permission> permissions;
}
