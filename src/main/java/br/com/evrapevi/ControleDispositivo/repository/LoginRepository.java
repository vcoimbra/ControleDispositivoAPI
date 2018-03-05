package br.com.evrapevi.ControleDispositivo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.evrapevi.ControleDispositivo.model.Login;

public interface LoginRepository extends MongoRepository<Login, String> {
	
	List<Login> findByUsuario(String usuario);
}
