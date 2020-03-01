package com.felipegabriel.fcashapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "tipo_receita")
@NoArgsConstructor
@AllArgsConstructor
public class TipoReceita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pktiporeceita")
	private Integer pkTipoReceita;
	
	@Column(name = "tiporeceita")
	private String tipoReceita;
}
