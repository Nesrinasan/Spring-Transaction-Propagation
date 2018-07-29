package com.byteslounge.spring.tx.dao.impl;


import com.byteslounge.spring.tx.dao.AdminDAO;
import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.Admin;
import com.byteslounge.spring.tx.model.User;
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
