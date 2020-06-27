package br.com.departamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbVLan")
public class VlanEntity {

	// FIELDS //
	@Id
	@Column(name = "idVLan")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
	private DepartamentoEntity departamento;

	@Column(name = "enderecoVLan")
	private String endereco;

	// RELATIONS //
	@OneToOne(mappedBy = "vlan")
	private UsuarioEntity usuario;

}
