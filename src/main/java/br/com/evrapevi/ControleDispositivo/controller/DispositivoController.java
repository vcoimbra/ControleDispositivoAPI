package br.com.evrapevi.ControleDispositivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evrapevi.ControleDispositivo.component.DispositivoComponent;
import br.com.evrapevi.ControleDispositivo.model.Dispositivo;

@RestController
@RequestMapping("dispositivo")
public class DispositivoController {
	
	@Autowired
	public DispositivoComponent dispositivoComponent;
	
	@GetMapping("/uuid/{uuid}")
	public Dispositivo buscarDispositivo(@PathVariable(value = "uuid") String uuid) {
		return dispositivoComponent.buscarDispositivo(uuid);
	}
	
	@GetMapping
	public List<Dispositivo> buscarTodos(){
		return dispositivoComponent.buscarTodos();
	}
	
	@DeleteMapping("/uuid/{uuid}")
	public void apagar(@PathVariable(value="uuid") String uuid) {
		dispositivoComponent.apagar(uuid);
	}
	
	@PostMapping
	public void salvar(@RequestBody Dispositivo dispositivo) {
		dispositivoComponent.salvar(dispositivo);
	}

}
