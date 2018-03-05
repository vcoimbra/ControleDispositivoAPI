package br.com.evrapevi.ControleDispositivo.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evrapevi.ControleDispositivo.model.Dispositivo;
import br.com.evrapevi.ControleDispositivo.repository.DispositivoRepository;

@Component
public class DispositivoComponent {

	@Autowired
	DispositivoRepository dispositivoRepository;

	public void salvar(Dispositivo dispositivo) {
		List<Dispositivo> dispositivos = dispositivoRepository.findByUuid(dispositivo.getUuid());
		if (!dispositivos.isEmpty()) {
			dispositivo.setId(dispositivos.get(0).getId());
		}
		dispositivoRepository.save(dispositivo);
	}

	public Dispositivo buscarDispositivo(String uuid) {
		List<Dispositivo> dispositivos = dispositivoRepository.findByUuid(uuid);
		if (dispositivos.isEmpty()) {
			return new Dispositivo();
		} else {
			return dispositivos.get(0);
		}
	}

	public List<Dispositivo> buscarTodos() {
		return dispositivoRepository.findAll();
	}

	public void apagar(String uuid) {
		List<Dispositivo> dispositivos = dispositivoRepository.findByUuid(uuid);
		if (!dispositivos.isEmpty()) {
			dispositivoRepository.delete(dispositivos.get(0));
		}
	}
}
