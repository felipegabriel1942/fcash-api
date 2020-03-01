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
@Table(name = "despesa")
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkdespesa")
	private Integer pkDespesa;
	
	private String despesa;
	
	@Column(name = "datadespesa")
	private Date dataDespesa;
	
	@Column(name = "valordespesa")
	private Float valorDespesa;
	
	@ManyToOne
	@JoinColumn(name = "fktipodespesa")
	private TipoDespesa fkTipoDespesa;
	
	@ManyToOne
	@JoinColumn(name = "fkusuario")
	private Usuario fkUsuario;
}
