package com.felipegabriel.fcashapi.resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipegabriel.fcashapi.model.Despesa;
import com.felipegabriel.fcashapi.model.TipoDespesa;
import com.felipegabriel.fcashapi.model.Usuario;
import com.felipegabriel.fcashapi.service.DespesaService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@WebMvcTest(controllers = DespesaResource.class)
public class DespesaResourceTest {
	
	static String DESPESA_API = "/despesa";
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	DespesaService service;
	
	@Test
	@DisplayName("Deve salvar uma despesa com sucesso.")
	public void salvarDespesaTest() throws Exception {
		
		// Cenário
		Despesa despesa = Despesa.builder()
				.despesa("lanche")
				.dataDespesa(new Date())
				.valorDespesa(155.50F)
				.fkTipoDespesa(criarTipoDespesa())
				.fkUsuario(criarUsuario()).build();
		
		Despesa despesaSalva = Despesa.builder()
				.pkDespesa(1)
				.despesa("lanche")
				.dataDespesa(new Date())
				.valorDespesa(155.50F)
				.fkTipoDespesa(criarTipoDespesa())
				.fkUsuario(criarUsuario()).build();
		
		BDDMockito.given(service.salvarDespesa(Mockito.any(Despesa.class))).willReturn(despesaSalva);
		String json = new ObjectMapper().writeValueAsString(despesa);
		
		// Execução
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(DESPESA_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);
		
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("pkDespesa").value(1))
				.andExpect(jsonPath("despesa").value(despesa.getDespesa()))
				.andExpect(jsonPath("dataDespesa").exists())
				.andExpect(jsonPath("valorDespesa").value(despesa.getValorDespesa()))
				.andExpect(jsonPath("fkTipoDespesa").value(despesa.getFkTipoDespesa()))
				.andExpect(jsonPath("fkUsuario.email").value(despesa.getFkUsuario().getEmail()))
				.andExpect(jsonPath("fkUsuario.dataNascimento").exists())
				.andExpect(jsonPath("fkUsuario.senha").value(despesa.getFkUsuario().getSenha()))
				.andExpect(jsonPath("fkUsuario.pkUsuario").value(despesa.getFkUsuario().getPkUsuario()));		
	}
	
	@Test
	@DisplayName("Deve deletar uma despesa com sucesso.")
	public void deletarDespesa() throws Exception {
		BDDMockito.given(service.buscarDespesaPorId(Mockito.anyInt()))
				.willReturn(Despesa.builder().pkDespesa(1).build());
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.delete(DESPESA_API.concat("/" + 1));
		
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isNoContent());
		
	}
	
	public static TipoDespesa criarTipoDespesa() {
		return TipoDespesa.builder()
				.pkTipoDespesa(1)
				.tipoDespesa("alimentação").build();
	}
	
	public static Usuario criarUsuario() throws ParseException {
		return Usuario.builder()
				.email("pinheiro_felipeg@yahoo.com.br")
				.dataNascimento(new Date())
				.senha("123456")
				.pkUsuario(1).build();
	}
	
	public static Date criarData() {
		try {
			String dataString = "20-07-1988";
			DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			return sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
