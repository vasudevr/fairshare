package com.vasu.fairshare.account.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vasu.fairshare.account.model.User;


public class UserDAOImpl implements UserDAO {

private SessionFactory sessionFactory;
	
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		
		List<User> users = new ArrayList<User>();
		
		users = getSessionFactory().getCurrentSession().createQuery(" from User where username=?").setParameter(0, userName).list();
		
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
