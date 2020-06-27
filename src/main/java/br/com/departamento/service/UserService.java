package br.com.departamento.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.dto.TicketInfo;
import br.com.departamento.dto.UserInfo;
import br.com.departamento.repository.UsuarioRepository;

@Service
public class UserService {

	private UsuarioRepository repository;
	private SimpleDateFormat databaseFormat;
	private SimpleDateFormat outputFormat;

	@Autowired
	public UserService(UsuarioRepository repository) {
		this.repository = repository;
		databaseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}

	public UserInfo getInfo(final long id) {
		Object[] info = (Object[]) repository.findInfo(id);
		
		return UserInfo.builder()
				.name(String.valueOf(info[0]))
				.email(String.valueOf(info[1]))
				.department(String.valueOf(info[2]))
				.identifier(Long.parseLong(String.valueOf(info[3]))).build();
	}
	
	public List<TicketInfo> getTickets(final long id) {
		List<Object> tickets = repository.findTickets(id);
		return tickets.stream()
				.map(ticket -> {
					Object[] t = (Object[]) ticket;
					Date dateTime;
					try {
						dateTime = databaseFormat.parse(String.valueOf(t[2]));
					} catch (ParseException e) {
						dateTime = null;
					}
					return TicketInfo.builder()
							.ticketId(Long.parseLong(String.valueOf(t[0])))
							.user(String.valueOf(t[1]))
							.dateTime(outputFormat.format(dateTime)).build();
				}).collect(Collectors.toList());
	}
}
