package com.application.appointments.model.repository;

import java.util.List;

import com.application.appointments.model.domain.BaseModel;

public interface GenericRepository<T extends BaseModel> {

	List<T> findByColumn(String columnName, String columnValue);
	
	void save(T object);

}
