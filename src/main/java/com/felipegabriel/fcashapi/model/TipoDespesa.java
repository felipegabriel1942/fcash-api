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
@Table(name = "tipo_despesa")
@NoArgsConstructor
@AllArgsConstructor
public class TipoDespesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pktipodespesa")
	private Integer pkTipoDespesa;
	
	@Column(name = "tipodespesa")
	private String tipoDespesa;
}
