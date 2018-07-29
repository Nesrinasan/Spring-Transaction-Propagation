package com.spring.transaction.propagation.dao.impl;


import com.spring.transaction.propagation.dao.AdminDAO;
import com.spring.transaction.propagation.model.Admin;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
    public void insertAdmin(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }
}
