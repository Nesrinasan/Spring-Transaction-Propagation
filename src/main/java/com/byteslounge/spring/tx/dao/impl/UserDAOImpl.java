package com.byteslounge.spring.tx.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.byteslounge.spring.tx.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertUser_REQUIRES_NEW(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertUser_REQUIRED(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void insertUser_MANDATORY(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void insertUser_NEVER(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    public void insertUser_NESTED(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void insert_SUPPORT(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    public void insertUser_REQUIRES_NEW_BLOK(User user) {
        sessionFactory.getCurrentSession ().save (user);

    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void insert_NOT_SUPPORTED(User user) {
        sessionFactory.getCurrentSession ().save (user);
    }

    @Transactional(rollbackFor = ClassNotFoundException.class)
    public void insertUser_DIFF_ROLLBACK() {

        insertUser_DIFF_ROLLBACK1 ();
        insertUser_DIFF_ROLLBACK2 ();

    }

    public void insertUser_DIFF_ROLLBACK1() {
        User user = new User ();
        user.setName ("yeryüzü");
        sessionFactory.getCurrentSession ().save (user);
    }

    public void insertUser_DIFF_ROLLBACK2() {
        try {
            throw new ClassNotFoundException ();
//            User user = null;
//            user.setName ("gökyüzü");

        } catch (ClassNotFoundException e) {
            System.out.println ("hata aldınız.");
        }
//            Class.forName("StockTrading");
    }


    public User getUserById(int userId) {
        return (User) sessionFactory.getCurrentSession ().get (User.class, userId);
    }

    public User getUser(String username) {
        Query query = sessionFactory.getCurrentSession ().createQuery ("from User where username = :username");
        query.setParameter ("username", username);
        return (User) query.list ().get (0);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Criteria criteria = sessionFactory.getCurrentSession ().createCriteria (User.class);
        return criteria.list ();
    }
}
