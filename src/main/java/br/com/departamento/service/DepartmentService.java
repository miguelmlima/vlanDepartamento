package br.com.departamento.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.dto.DepartmenInfo;
import br.com.departamento.repository.UsuarioRepository;

@Service
public class DepartmentService {

	private UsuarioRepository repository;

	@Autowired
	public DepartmentService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public List<DepartmenInfo> list() {
		List<Object> tickets = repository.listDepartments();
		return tickets.stream().map(ticket -> {
			Object[] t = (Object[]) ticket;
			return DepartmenInfo.builder()
					.name(String.valueOf(t[0]))
					.vlanAddress(String.valueOf(t[1]))
					.vlanId(Long.parseLong(String.valueOf(t[2]))).build();
		}).collect(Collectors.toList());
	}
}
