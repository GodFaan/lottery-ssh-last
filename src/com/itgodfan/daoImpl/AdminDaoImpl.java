package com.itgodfan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.itgodfan.bean.Admin;
import com.itgodfan.bean.User;
import com.itgodfan.dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	private SessionFactory sessionFactory;

	public AdminDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session currentSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void add(Admin admin) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Admin admin) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.update(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			Admin admin = (Admin) session.get(Admin.class, id);
			session.delete(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Admin findUserByName(String name, String password) {
		Session session = null;
		Admin result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			// 注意，这里的Admin对应的是实体类的Admin而不是数据库的表名
			String hql = "from Admin a where a.name=:aname and a.password=:apassword";
			Query query = session.createQuery(hql);
			query.setParameter("aname", name);
			query.setParameter("apassword", password);
			result = (Admin) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Admin findUserById(int id) {
		Session session = null;
		Admin result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Admin a where a.id=:aid ";
			Query query = session.createQuery(hql);
			query.setParameter("aid", id);
			result = (Admin) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return result;

	}

	@Override
	public boolean findUserNameExist(String name) {
		Session session = null;
		Admin result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Admin a where a.name=:aname ";
			Query query = session.createQuery(hql);
			query.setParameter("aname", name);
			result = (Admin) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Admin> findAll() {
		Session session = null;
		List<Admin> list = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Admin";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
