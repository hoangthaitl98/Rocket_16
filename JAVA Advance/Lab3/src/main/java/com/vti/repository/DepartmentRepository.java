package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository(){
        hibernateUtils =HibernateUtils.getInstance();
    }

    public List<Department> getAllDepartment(){
        Session session = null;
        session = hibernateUtils.openSession();
        Query<Department> query = session.createQuery("FROM  Department ");
        return query.list();
    }

    public Department getDepartmentById(short departmentId){
        Session session = null;
        session = hibernateUtils.openSession();
        Query<Department> query = session.createQuery("from Department where id = :idParameter");
        query.setParameter("idParameter", departmentId);
        Department department = query.uniqueResult();
        return department;
    }

    public Department getDepartmentByName(String departmentName){
        Session session = null;
        session = hibernateUtils.openSession();
        Query<Department> query = session.createQuery("from Department where name = :nameParameter");
        query.setParameter("nameParameter", departmentName);
        Department department = query.uniqueResult();
        return department;
    }

    public void createDepartment(Department department){
        Session session = null;
        session = hibernateUtils.openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
    }

    public boolean isDepartmentExistById(short id){
        if (getDepartmentById(id) == null){
            return false;
        }
        else return true;
    }

    public boolean isDepartmentExistById(String name){
        if (getDepartmentByName(name) == null){
            return false;
        }
        else return true;
    }
}
