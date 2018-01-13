package com.application.appointments.model.service;

import com.application.appointments.model.domain.User;

public interface UserService {

	User findUserByEmail(String email);

	void saveUser(User user);

}
