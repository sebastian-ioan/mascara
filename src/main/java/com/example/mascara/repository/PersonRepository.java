package com.example.mascara.repository;


import com.example.mascara.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Repository
@Transactional
public class PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long save(Person person) {

        return (Long) sessionFactory.getCurrentSession().save(person);

    }


    public Iterable<Person> findAll() {

        return sessionFactory.getCurrentSession().createQuery("from Person", Person.class).list();

    }
}
