package com.byteslounge.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.user.UserManager;

public class Main 
{
    public static void main( String[] args ) throws Exception {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	UserManager userManager = (UserManager) ctx.getBean("userManagerEntityService");
//        AdminManager adminManager = (AdminManager) ctx.getBean("adminManagerEntityService");

//    	User user = new User();
//    	user.setName("eee");
        userManager.insert ();

//        Admin admin = new Admin ();
//        admin.setName ("dd");
//        adminManager.insertAdmin (admin);

    	System.out.println("User inserted!");
    	
//    	user = userManager.getUser("johndoe");

    	List<User> users = userManager.getUsers();
    	
    	System.out.println("\nUser list fetched!"
        	+ "\nUser count: " + users.size());

    }
}
