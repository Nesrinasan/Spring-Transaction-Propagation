package com.spring.transaction.propagation.dao.impl;

/**
 * Created by Universal on 7/27/2018.
 */
public class myCheckedEx extends Exception {

    public myCheckedEx(String message) {
        super(message);
    }

}
