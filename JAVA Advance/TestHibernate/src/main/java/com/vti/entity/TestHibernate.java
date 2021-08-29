package com.vti.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class TestHibernate {
    public static void main(String[] args) {
        Session session = null;
        session = buildSessionFactory().openSession();
        //Select data
        Query<TestingCategory> query = session.createQuery("from  TestingCategory");
        List<TestingCategory> categories = query.list();
        for (int i = 0; i < categories.size(); i++) {
            System.out.println("ID: " + categories.get(i).getId() + " Name: " + categories.get(i).getName());
        }

        //Insert data
        session.beginTransaction();
        TestingCategory testingCategory = new TestingCategory();
        testingCategory.setName("test");
        session.save(testingCategory);
        session.getTransaction().commit();
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(TestingCategory.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
