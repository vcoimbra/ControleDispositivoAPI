package br.com.evrapevi.ControleDispositivo.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evrapevi.ControleDispositivo.model.Login;
import br.com.evrapevi.ControleDispositivo.pojo.RetornoLogin;
import br.com.evrapevi.ControleDispositivo.repository.LoginRepository;
import br.com.evrapevi.ControleDispositivo.util.EnumRetornoLogin;

@Component
public class LoginComponent {

	@Autowired
	LoginRepository loginRepository;

	public RetornoLogin salvar(Login login) {
		List<Login> dispositivos = loginRepository.findByUsuario(login.getUsuario());
		RetornoLogin retornoLogin = new RetornoLogin();
		
		if (!dispositivos.isEmpty()) {
			login.setId(dispositivos.get(0).getId());
			retornoLogin.setValor(EnumRetornoLogin.USUARIO_EXISTENTE.getValor());
		} else {
			loginRepository.save(login);
			retornoLogin.setValor(EnumRetornoLogin.USUARIO_CADASTRADO.getValor());
		}		
		return retornoLogin;
	}
	//so sera utilizado para visualizaçao no postman
	public List<Login> buscarTodos() {
		return loginRepository.findAll();
	}

	public RetornoLogin autenticarUsuario(String usuario, String senha) {
		List<Login> logins = loginRepository.findByUsuario(usuario);
		RetornoLogin retornoLogin = new RetornoLogin();
		if (logins.isEmpty()) {
			retornoLogin.setValor(EnumRetornoLogin.USUARIO_NAO_AUTORIZADO.getValor());
		
		} else {
			if (senha.equals(logins.get(0).getSenha())) {
				retornoLogin.setValor(EnumRetornoLogin.USUARIO_AUTENTICADO.getValor());
			} else {
				retornoLogin.setValor(EnumRetornoLogin.USUARIO_NAO_AUTORIZADO.getValor());
			}
		}
		
		return retornoLogin;
	}
}
