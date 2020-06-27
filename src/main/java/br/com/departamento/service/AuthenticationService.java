package br.com.departamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.exception.UserAuthenticationException;
import br.com.departamento.repository.UsuarioRepository;


@Service
public class AuthenticationService {
	
	private UsuarioRepository repository;
	
	@Autowired
	public AuthenticationService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public void authenticate(final long id, final String password) {
		if(repository.authenticate(id, password) == 0)
			throw new UserAuthenticationException(id);
	}
}
