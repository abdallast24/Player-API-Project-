package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Player;

@Repository // this class will deal with DB
public class PlayerDaoImp implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Player> getPlayers() {

		Session session = sessionFactory.getCurrentSession();
		session.clear();
		List<Player> list = session.createQuery("from Player").getResultList();

//		list.add(new Player("Mo Salah",10,"Zagazig"));
//		list.add(new Player("CR Ronaldo",7,"Portugal"));
//		list.add(new Player("Messi",10,"Argantina"));

		return list;
	}

	@Override
	public void savePlayer(Player player) {
		sessionFactory.getCurrentSession().saveOrUpdate(player);
	}

	@Override
	public Player getPlayer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		
		return session.get(Player.class, id);
	}

	@Override
	public void delete(Player player) {
		sessionFactory.getCurrentSession().delete(player);
	}

}