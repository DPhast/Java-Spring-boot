package com.example.identityService.service;


import com.example.identityService.dto.request.PermissionRequest;
import com.example.identityService.dto.request.RoleRequest;
import com.example.identityService.dto.response.PermissionResponse;
import com.example.identityService.dto.response.RoleResponse;
import com.example.identityService.entity.Permission;
import com.example.identityService.entity.Role;
import com.example.identityService.mapper.PermissionMapper;
import com.example.identityService.mapper.RoleMapper;
import com.example.identityService.repository.PermissionRepository;
import com.example.identityService.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    public RoleResponse create (RoleRequest request){
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return  roleMapper.toRoleResponse(role);

    }

    public List<RoleResponse> getAll(){

        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
