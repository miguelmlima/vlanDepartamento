package br.com.departamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmenInfo {
	private String name;
	private String vlanAddress;
	private Long vlanId;
}
