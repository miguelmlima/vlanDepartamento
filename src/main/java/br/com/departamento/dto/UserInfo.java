package br.com.departamento.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	private String name;
	private String email;
	private String department;
	private Long identifier;
	private List<TicketInfo> tickets;
}
