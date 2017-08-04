package br.com.contractMan.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.contractMan.daos.RestauranteDao;
import br.com.contractMan.models.Restaurantes;

@Controller
public class RestauranteController {

	@Autowired
	RestauranteDao dao;
	
	@RequestMapping(value = "/restaurante/adiciona", method = RequestMethod.POST)
	public void adiciona(@RequestBody Restaurantes restaurante) {
		dao.save(restaurante);
	}
	
	@RequestMapping(value = "restaurante/random", method = RequestMethod.GET)
	public @ResponseBody String getRandomRestaurant() {
		List<Restaurantes> lista = (List<Restaurantes>) dao.findAll();
		Random rnd = new Random();
	    int i = rnd.nextInt(lista.size());
	    Restaurantes restaurante = lista.get(i);
		return restaurante.toString(); 
	}
	
	@RequestMapping(value="/lunch", method= RequestMethod.POST)
	public @ResponseBody String choose(String tipo) {
		List<Restaurantes> list = dao.findByTipo(tipo);
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/restaurante/delete/{nome}", method = RequestMethod.POST)
	public void deletar(@PathVariable(value="nome") String nome) {
		Restaurantes restaurante = dao.findByNome(nome);
		dao.delete(restaurante);
	}

	@RequestMapping(value = "/restaurante}", method = RequestMethod.GET)
	public String list() {
		List<Restaurantes> all = (List<Restaurantes>) dao.findAll();
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurantes: \n");
		for (Restaurantes r : all) {
			builder.append(r.getNome() + "\n");
		}
		return builder.toString();
	}
	
}
