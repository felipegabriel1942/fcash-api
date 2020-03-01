package com.felipegabriel.fcashapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "receita")
@NoArgsConstructor
@AllArgsConstructor
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkreceita")
	private Integer pkReceita;
	
	private String receita;
	
	@Column(name = "datereceita")
	private Date dataReceita;
	
	@Column(name = "valorreceita")
	private Float valorReceita;
	
	@ManyToOne
	@JoinColumn(name = "fktiporeceita")
	private TipoReceita fkTipoReceita;
	
	@ManyToOne
	@JoinColumn(name = "fkusuario")
	private Usuario fkUsuario;
}
