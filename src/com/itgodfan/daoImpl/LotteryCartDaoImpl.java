package com.itgodfan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.dao.LotteryCartDao;

public class LotteryCartDaoImpl implements LotteryCartDao {
	private SessionFactory sessionFactory;
	public LotteryCartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session currentSession() {
		return sessionFactory.openSession();
	}
	@Override
	public void add(LotteryCart lotteryCart) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.save(lotteryCart);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(LotteryCart lotteryCart) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			session.update(lotteryCart);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int bid) {
		Session session = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			LotteryCart lotteryCart = (LotteryCart) session.get(LotteryCart.class, bid);
			session.delete(lotteryCart);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<LotteryCart> findAll(String username) {

		Session session = null;
		List<LotteryCart> list = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from LotteryCart l where l.username=:name";
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
	@Override
	public LotteryCart findCartById(int bid) {
		Session session = null;
		LotteryCart result = null;
		try {
			session = currentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from LotteryCart l where l.id=:lid ";
			Query query = session.createQuery(hql);
			query.setParameter("lid", bid);
			result = (LotteryCart) query.uniqueResult();
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
