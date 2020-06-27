package br.com.departamento.entity;

import javax.persistence.CascadeType;
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
@Table(name = "tbUsuario")
public class UsuarioEntity {

	// FIELDS //
	@Id
	@Column(name = "idUsuario")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
	private DepartamentoEntity departamento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idVLan", referencedColumnName = "idVLan")
	private VlanEntity vlan;

	@Column(name = "nomeUsuario")
	private String nome;

	@Column(name = "numserie") // TODO join maquina
	private Long numSerie;

	@Column(name = "eMail")
	private String email;

	@Column(name = "segredo")
	private String segredo;

}
