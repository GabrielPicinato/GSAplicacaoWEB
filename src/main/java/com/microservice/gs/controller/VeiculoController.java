package com.microservice.gs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.microservice.gs.model.Veiculo;
import com.microservice.gs.repository.VeiculoRepository;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repo;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("veiculolista", repo.findAll());
		return "homepage";
	}
	
	@GetMapping("/salvarVeiculo")
	public String salvarVeiculo(Model model) {
		Veiculo veiculo = new Veiculo();
		model.addAttribute("veiculo", veiculo);
		return "cadastrarVeiculo";
	}
	
	@PostMapping("/salvarVeiculo")
	public String salvarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
		repo.save(veiculo);
		return "cadastrarVeiculo";
	} 
	
	@GetMapping("/updateVeiculoPage/{id}")
	public String showUpdateVeiculoPage(@PathVariable("id") Long id, Model model) {
		Optional<Veiculo> temp=repo.findById(id);
		Veiculo veiculo=temp.get();
		model.addAttribute("veiculo",veiculo);
		return "atualizarVeiculo";
	}
	
	@GetMapping("/deleteVeiculo/{id}")
	public String deleteVeiculo(@PathVariable("id") Long id) {
		
		repo.deleteById(id);
		return "redirect:/";
	}
}
