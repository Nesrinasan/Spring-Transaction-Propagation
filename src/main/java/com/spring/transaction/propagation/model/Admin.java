package com.spring.transaction.propagation.model;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @SequenceGenerator(name = "generator", sequenceName = "ADMIN_SEQ_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @Column
    private int id;

    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
