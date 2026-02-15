package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.PlayerException;
import com.spring.model.Player;
import com.spring.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/players")
	public List<Player> getPlayers() {
		List<Player> players = playerService.getAllPlayers();
		return players;
	}

	@GetMapping("/players/{id}")
	public Player getPlayersByID(@PathVariable("id") int id) {
		Player p = playerService.showPlayer(id);

		if (p == null)
			throw new PlayerException("can't find a player with this id = " + id);

		return p;
	}

	@PostMapping("/players")
	public Player saveplayer(@RequestBody Player p) {

		playerService.addPlayer(p);

		return p;
	}

	@DeleteMapping("/players/{id}")
	public String deletePlayer(@PathVariable("id") int id) {
		Player p = playerService.showPlayer(id);

		if (p == null)
			throw new PlayerException("can't find a player with this id = " + id);

		playerService.deletePlayer(id);

		return "deleted Successfully!";
	}

	@PutMapping("/players")
	public void editPlayer(@RequestBody Player p) {

		if (!playerService.isFound(p.getId()))
			throw new PlayerException("can't find this player");

		playerService.addPlayer(p);

	}

}
