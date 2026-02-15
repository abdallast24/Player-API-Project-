package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.PlayerDAO;
import com.spring.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO dao;

	@Override
	@Transactional
	public List<Player> getAllPlayers() {
		return dao.getPlayers();
	}

	@Override
	@Transactional

	public void addPlayer(Player player) {
		dao.savePlayer(player);
	}

	@Override
	@Transactional
	public Player showPlayer(int id) {
		return dao.getPlayer(id);
	}

	@Override
	@Transactional
	public void deletePlayer(int id) {
		dao.delete(dao.getPlayer(id));
	}

	@Override
	@Transactional
	public boolean isFound(int id) {
		return dao.getPlayer(id) != null;
	}

}