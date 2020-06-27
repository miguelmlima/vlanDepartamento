package br.com.departamento.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.dto.TicketResponse;
import br.com.departamento.repository.UsuarioRepository;


@Service
public class TicketService {
	
	private UsuarioRepository repository;
	
	@Autowired
	public TicketService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public TicketResponse register(final long id, final long vlan, final Date dateTime, final String reason) {
		return TicketResponse.builder()
				.command(repository.insertTicket(id, vlan, dateTime, reason))
				.build();
	}
}
