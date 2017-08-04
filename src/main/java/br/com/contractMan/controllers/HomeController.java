package br.com.contractMan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.contractMan.daos.EventosDao;
import br.com.contractMan.daos.RestauranteDao;
import br.com.contractMan.models.Eventos;

@Controller
public class HomeController {

	@Autowired
	RestauranteDao dao;
	
	@Autowired
	EventosDao eventoDao;
	
	@GetMapping("/")
	public String index() {
		return "home/home";
	}
	
}
