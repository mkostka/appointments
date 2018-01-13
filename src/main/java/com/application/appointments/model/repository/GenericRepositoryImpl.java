package com.application.appointments.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.core.GenericTypeResolver;

import com.application.appointments.model.domain.BaseModel;

public class GenericRepositoryImpl<T extends BaseModel> implements GenericRepository<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> genericType;

	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl() {
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericRepositoryImpl.class);
	}

	@Override
	public List<T> findByColumn(String columnName, String columnValue) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(genericType);
		Root<T> root = criteriaQuery.from(genericType);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get(columnName), columnValue));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public T findUniqueByColumn(String columnName, String columnValue) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(genericType);
		Root<T> root = criteriaQuery.from(genericType);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get(columnName), columnValue));
		try {
			return entityManager.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(T object) {
		entityManager.persist(object);

	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
