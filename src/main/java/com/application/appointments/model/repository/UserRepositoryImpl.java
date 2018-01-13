package com.application.appointments.model.repository;

import org.springframework.stereotype.Repository;

import com.application.appointments.model.domain.User;

@Repository("userRepository")
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

}
