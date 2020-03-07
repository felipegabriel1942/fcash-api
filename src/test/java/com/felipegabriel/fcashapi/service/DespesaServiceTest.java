package com.felipegabriel.fcashapi.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.felipegabriel.fcashapi.model.Despesa;
import com.felipegabriel.fcashapi.model.Usuario;
import com.felipegabriel.fcashapi.repository.DespesaRepository;
import com.felipegabriel.fcashapi.resource.DespesaResourceTest;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class DespesaServiceTest {
	
	DespesaService service;
	
	@MockBean
	DespesaRepository repository;
	
	@BeforeEach
	public void setUp() {
		this.service = new DespesaService(repository);
	}
	
	@Test
	@DisplayName("Deve salvar uma despesa")
	public void salvarDespesaTest() throws Exception {
		
		Usuario usuario = DespesaResourceTest.criarUsuario();
		Date data = DespesaResourceTest.criarData();
		
		// Cenario
		Despesa despesa = Despesa.builder()
				.despesa("lanche")
				.dataDespesa(data)
				.valorDespesa(155.50F)
				.fkTipoDespesa(DespesaResourceTest.criarTipoDespesa())
				.fkUsuario(usuario).build();
		
		Mockito.when(repository.save(despesa)).thenReturn(
				Despesa.builder().pkDespesa(1)
						.despesa("lanche")
						.dataDespesa(data)
						.valorDespesa(155.50F)
						.fkTipoDespesa(DespesaResourceTest.criarTipoDespesa())
						.fkUsuario(usuario).build()
		);
		
		// execução
		Despesa despesaSalva = service.salvarDespesa(despesa);
		
		// verificação
		assertThat(despesaSalva.getPkDespesa()).isNotNull();
		assertThat(despesaSalva.getDespesa()).isEqualTo("lanche");
		assertThat(despesaSalva.getDataDespesa()).isEqualTo(data);
		assertThat(despesaSalva.getValorDespesa()).isEqualTo(155.50F);
		assertThat(despesaSalva.getFkTipoDespesa()).isEqualTo(DespesaResourceTest.criarTipoDespesa());
		assertThat(despesaSalva.getFkUsuario()).isEqualTo(usuario);		
	}
}
