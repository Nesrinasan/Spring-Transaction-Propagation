package com.byteslounge.spring.tx.admin.impl;

import com.byteslounge.spring.tx.admin.AdminManager;
import com.byteslounge.spring.tx.dao.AdminDAO;
import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.Admin;
import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.user.UserManager;
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
