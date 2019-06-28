package com.itgodfan.daoImpl;

import java.util.List;

import org.hibernate.*;

import com.itgodfan.bean.User;
import com.itgodfan.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session currentSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void add(User user) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(User user) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.update(user);
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
			User user = (User) session.get(User.class, id);
			session.delete(user);
			tx.commit();
			System.out.println("shanchuchengongle!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public User findUserByName(String name, String password) {
		Session session = null;
		User result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			//注意，这里的User对应的是实体类的user而不是数据库的表名
			String hql = "from User u where u.name=:uname and u.password=:upassword";
			Query query = session.createQuery(hql);
			query.setParameter("uname", name);
			query.setParameter("upassword", password);
			result = (User) query.uniqueResult();
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
	public User findUserById(int id) {
		Session session = null;
		User result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User u where u.id=:uid ";
			Query query = session.createQuery(hql);
			query.setParameter("uid", id);
			result = (User) query.uniqueResult();
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
	public List<User> findAll() {
		Session session = null;
		List<User> list = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User";
			Query query = session.createQuery(hql);
			list = query.list();
			System.out.println("daxiao "+list.size());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean findUserNameExist(String name) {
		Session session = null;
		User result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User u where u.name=:uname ";
			Query query = session.createQuery(hql);
			query.setParameter("uname", name);
			result = (User) query.uniqueResult();
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
	public User findUserByOnlyName(String name) {
		Session session = null;
		User result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			//注意，这里的User对应的是实体类的user而不是数据库的表名
			String hql = "from User u where u.name=:uname";
			Query query = session.createQuery(hql);
			query.setParameter("uname", name);
			result = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return result;
	}

}
