package com.vti.repository;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountRepository {
    private HibernateUtils hibernateUtils;

    public AccountRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Account> getAllAccount(){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> query = session.createQuery("FROM Account ");
            return query.list();
            /*CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> query = builder.createQuery(Account.class);
            Root<Account> root = query.from(Account.class); //FROM Account
            query.select(root); //SELECT
            List<Account> accounts = session.createQuery(query).list();
            return accounts;*/
        }finally {
            if (session != null)
                session.close();
        }

    }

    public Account getById(short id){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> query = session.createQuery("FROM  Account WHERE Account.id = :id");
            query.setParameter("id", id);
            Account account = query.uniqueResult();
            /*CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> query = builder.createQuery(Account.class);
            Root<Account> root = query.from(Account.class); //FROM Account
            query.select(root);
            query.where(builder.equal(root.get("id"), id)); //WHERE Account.id = id
            Account account = session.createQuery(query).uniqueResult();*/
            return account;
        }finally {
            if (session != null)
                session.close();
        }
    }

    public String getFullname(short id){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<String> query = session.createQuery("SELECT Account.fullname FROM Account WHERE Account.id =:id");
            query.setParameter("id", id);
            return query.uniqueResult();
        }finally {
            if (session != null)
                session.close();
        }
    }

    public List<Account> getAccountInCurrentMonth(){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Account> query = session.createQuery("")
        }finally {
        }
    }

    public List<Object[]> getAccountByMonthInYearCurrent(){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // Account như bên trên.
            String hql = "SELECT month(createDate) AS month, COUNT(createDate) AS SL FROM Account WHERE year(createDate) = year(sysdate()) GROUP BY month(createDate)";
            //Kết quả trả về là 1 mảng kiểu đổi tượng
            Query<Object[]> query = session.createQuery(hql);
            //get result: trả về 1 list mảng các đối tượng
            List<Object[]> results = query.list();
            return results;

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
