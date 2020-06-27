package br.com.departamento.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.departamento.dto.DepartmenInfo;
import br.com.departamento.dto.LoginRequest;
import br.com.departamento.dto.TicketInfo;
import br.com.departamento.dto.TicketRequest;
import br.com.departamento.dto.TicketResponse;
import br.com.departamento.dto.UserInfo;
import br.com.departamento.service.AuthenticationService;
import br.com.departamento.service.DepartmentService;
import br.com.departamento.service.TicketService;
import br.com.departamento.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api")
@Slf4j
public class ApplicationController {

	private AuthenticationService authenticationService;
	private UserService userService;
	private DepartmentService departmentService;
	private TicketService ticketService;

	@Autowired
	public ApplicationController(AuthenticationService authenticationService, UserService userService,
			DepartmentService departmentService, TicketService ticketService) {
		this.authenticationService = authenticationService;
		this.userService = userService;
		this.departmentService = departmentService;
		this.ticketService = ticketService;
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void postLogin(@Valid @RequestBody LoginRequest login) {
		log.info("Login input: {}", login);
		authenticationService.authenticate(login.getIdentifier(), login.getPassword());
	}

	@GetMapping(value = "/user/{identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody UserInfo getUser(@PathVariable Integer identifier) {
		log.info("User id: {}", identifier);
		return userService.getInfo(identifier);
	}
	
	@GetMapping(value = "/user/{identifier}/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<TicketInfo> getUserTickets(@PathVariable Integer identifier) {
		log.info("User id: {}", identifier);
		return userService.getTickets(identifier);
	}
	
	@GetMapping(value = "/user/{identifier}/allinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody UserInfo getUserAllInfo(@PathVariable Integer identifier) {
		log.info("User id: {}", identifier);
		UserInfo user = userService.getInfo(identifier);
		user.setTickets(userService.getTickets(identifier));
		return user;
	}
	
	@GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<DepartmenInfo> getDepartments() {
		log.info("Get departments");
		return departmentService.list();
	}
	
	@PostMapping(value = "/user/{identifier}/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody TicketResponse postUserTicket(@PathVariable Integer identifier, @Valid @RequestBody TicketRequest ticket) {
		log.info("User id: {} | Login input: {}", identifier, ticket);
		return ticketService.register(identifier, ticket.getVlanId(), new Date(), ticket.getReason());
	}
}

















