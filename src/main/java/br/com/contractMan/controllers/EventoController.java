package br.com.contractMan.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import br.com.contractMan.daos.EventosDao;
import br.com.contractMan.models.Eventos;

@Controller
public class EventoController {

	@Autowired
	EventosDao dao;
	
	@RequestMapping(value = "evento/adiciona", method = RequestMethod.POST)
	public @ResponseBody String adiciona(@RequestBody Eventos evento) {
		LocalDateTime data = LocalDateTime.now();
		evento.setData(data);
		dao.save(evento);
		return evento.toString();
	}
	
	@GetMapping(value = "evento/{id}/enter/{nome}")	
	public @ResponseBody String enterEvento(@PathVariable(value="nome") String nome, @PathVariable(value="id") Long id) {
		Eventos evento = dao.findById(id);
		String usuarios = evento.getUsuarios();
		StringBuilder builder = new StringBuilder();
		builder.append(usuarios);
		builder.append(", " + nome);
		evento.setUsuarios(builder.toString());
		dao.save(evento);
		return evento.toString(); 
	}
	

	@GetMapping("/evento")
	public @ResponseBody String event() {
		List<Eventos> list = (List<Eventos>) dao.findAll();
		StringBuilder builder = new StringBuilder();
		builder.append("Eventos:\n");
		for (Eventos evento : list) {
			builder.append(evento.getNome() + "\n");
		}
		return builder.toString();
	}

}
