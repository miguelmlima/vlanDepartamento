package br.com.departamento.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "tbDepartamento")
public class DepartamentoEntity {

	// FIELDS //
	@Id
	@Column(name = "idDepartamento")
	private Long id;

	@Column(name = "nomeDepartamento")
	private String nome;

	// RELATIONS //
	@OneToMany(mappedBy = "departamento")
	private Set<UsuarioEntity> usuarios;

	@OneToMany(mappedBy = "departamento")
	private Set<VlanEntity> vlans;

}
