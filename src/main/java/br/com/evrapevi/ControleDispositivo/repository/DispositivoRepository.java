package br.com.evrapevi.ControleDispositivo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.evrapevi.ControleDispositivo.model.Dispositivo;

public interface DispositivoRepository extends MongoRepository<Dispositivo, String> {
	
	List<Dispositivo> findByUuid(String Uuid);
}
