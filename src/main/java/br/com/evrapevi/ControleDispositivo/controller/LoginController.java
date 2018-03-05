package br.com.evrapevi.ControleDispositivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.evrapevi.ControleDispositivo.component.LoginComponent;
import br.com.evrapevi.ControleDispositivo.model.Login;
import br.com.evrapevi.ControleDispositivo.pojo.RetornoLogin;

@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	public LoginComponent loginComponent;
	
	@GetMapping("/usuario")
	public RetornoLogin autenticarUsuario(@RequestParam(value = "usuario") String usuario,
			@RequestParam(value = "senha") String senha) {
		return loginComponent.autenticarUsuario(usuario, senha);
	}
	
	//so sera usado no postaman
	@GetMapping
	public List<Login> buscarTodos(){
		return loginComponent.buscarTodos();
	}
	
	@PostMapping
	public RetornoLogin salvar(@RequestBody Login login) {
		return loginComponent.salvar(login);
	}
	
	

}
