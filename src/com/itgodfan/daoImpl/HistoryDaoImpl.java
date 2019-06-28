package com.itgodfan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.itgodfan.bean.History;
import com.itgodfan.bean.LotteryCart;
import com.itgodfan.dao.HistoryDao;

public class HistoryDaoImpl implements HistoryDao {
	private SessionFactory sessionFactory;
	
	public HistoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session currentSession() {
		return sessionFactory.openSession();
	}
	@Override
	public void add(History history) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.save(history);
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
			History history=(History) session.get(History.class, id);
			session.delete(history);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public History findHistoryById(int id) {
		Session session = null;
		History result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from History h where h.id=:hid ";
			Query query = session.createQuery(hql);
			query.setParameter("hid", id);
			result = (History) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<History> findAll(String username) {
		Session session = null;
		List<History> list = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from History h where h.username=:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", username);
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
