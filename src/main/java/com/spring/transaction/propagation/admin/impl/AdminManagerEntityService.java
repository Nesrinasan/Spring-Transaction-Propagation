package com.spring.transaction.propagation.admin.impl;

import com.spring.transaction.propagation.admin.AdminManager;
import com.spring.transaction.propagation.dao.AdminDAO;
import com.spring.transaction.propagation.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminManagerEntityService implements AdminManager {

	@Autowired
	private AdminDAO adminDAO;
	
	@Transactional
	public void insertAdmin(Admin admin) {
		adminDAO.insertAdmin(admin);
	}
}
