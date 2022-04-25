package com.OcProject.PayMyBuddy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnection {

	//private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnection.class);
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mybuddy");
	public static EntityManager em;

	public static EntityManager currentEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public Connection getConnection() {
		SessionImpl hibernateSession = currentEntityManager().unwrap(SessionImpl.class);
		return hibernateSession.connection();
	}
	
	
	public static <T> T find(Class<T> entityClass, Object primaryKey) {
		currentEntityManager().flush();
		currentEntityManager().clear();
		T result = currentEntityManager().find(entityClass, primaryKey);
		return result;
	}
	
	public static <T> List<T> loadAll(Class<T> entityClass) {
		currentEntityManager().flush();
		currentEntityManager().clear();
		Query result = currentEntityManager().createQuery("SELECT e FROM "+entityClass.getName());
		return result.getResultList();
	}
	
	public void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Object persist(Object entity) {
		currentEntityManager().persist(entity);
		currentEntityManager().flush();
		currentEntityManager().clear();
		return entity;
	}
	
	public static boolean remove(Object entity) {
		if (entity == null) {
			return false;
		}
		try {
			if(!currentEntityManager().contains(entity)) {
				entity = currentEntityManager().merge(entity);
			}
			currentEntityManager().remove(entity);
			currentEntityManager().flush();
			currentEntityManager().clear();
		
		} catch(PersistenceException e) {
			//LOG.error(e.getMessage());
		}
		return true;
	}
	
	public static Object merge(Object entity) {
		currentEntityManager().merge(entity);
		currentEntityManager().flush();
		currentEntityManager().clear();
		return entity;
	}

}
