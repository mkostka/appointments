package com.application.appointments.model.repository;

import org.springframework.stereotype.Repository;

import com.application.appointments.model.domain.Role;

@Repository("roleRepository")
public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements RoleRepository {

}
