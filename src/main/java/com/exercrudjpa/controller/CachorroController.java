package com.exercrudjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercrudjpa.entidades.Cachorro;
import com.exercrudjpa.repository.CachorroRepository;

@Controller
@RequestMapping("/")
public class CachorroController {
	
	@Autowired
	private CachorroRepository repoC;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastrocachorro")
	public String formCachorro() {
		return "cadastrocachorro";
	}
	
	@GetMapping("/consultacachorro")
	public String formCachorro(Model model) {
		Iterable<Cachorro> cachorros = repoC.findAll();
		model.addAttribute("cachorros", cachorros);
		return "consultacachorro";
	}
	
	@GetMapping("/consultacachorro/{idcachorro}")
	public String formEditar(@PathVariable("idcachorro") int id, Model model) {
		Cachorro cachorro = repoC.findById(id).get();
		model.addAttribute("cachorro",cachorro);
		return "edicaocachorro";
	}
	
	@PostMapping("/cadastrocachorro")
	public String salvar(Cachorro cachorro) {
		repoC.save(cachorro);
		return "redirect:/consultacachorro";
	}
	
	@GetMapping("/deletec/{idcachorro}")
	public String deletec(@PathVariable("idcachorro") int id) {
		repoC.deleteById(id);
		return "redirect:/consultacachorro";
	}
}
