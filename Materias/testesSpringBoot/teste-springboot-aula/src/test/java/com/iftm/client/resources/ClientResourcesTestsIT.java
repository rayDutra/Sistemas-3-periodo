package com.iftm.client.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iftm.client.dto.ClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientResourcesTestsIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void verificaInsercaoDeUmClienteRetornaCodigoStatusCreated() throws Exception {
        // Crie um objeto ClientDTO com os dados que você deseja inserir
        ClientDTO clientDTO = new ClientDTO(
                null,
                "Amanda",
                "123456789",
                5000.0,
                Instant.parse("1990-01-01T00:00:00Z"),
                2
        );

        // Converta o objeto ClientDTO para JSON
        String json = objectMapper.writeValueAsString(clientDTO);

        // Realize a requisição POST para "/clients/"
        ResultActions result = mockMvc.perform(post("/clients/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Verifique se o status da resposta é 201 (created)
        result.andExpect(status().isCreated());

        // Verifique se o corpo da resposta contém os atributos desejados
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").value("Amanda"));
    }
    @Test
    public void verificaExclusaoDeUmClienteComIDExistenteRetornaCodigoDeStatusNoContent() throws Exception {
        // Id do cliente a ser excluído
        Long clientId = 1L;

        // Realize a requisição DELETE para "/clients/{id}"
        ResultActions result = mockMvc.perform(delete("/clients/{id}", clientId));

        // Verifique se o status da resposta é 204 (no content)
        result.andExpect(status().isNoContent());
    }

    @Test
    public void verificaSeExclusaoDeUmClienteIDInexistenteRetornaCodigoDeStatusNotFound() throws Exception {
        // Id do cliente que não existe
        Long clientId = 100L;

        // Realize a requisição DELETE para "/clients/{id}"
        ResultActions result = mockMvc.perform(delete("/clients/{id}", clientId));

        // Verifique se o status da resposta é 404 (not found)
        result.andExpect(status().isNotFound());
    }

    @Test
    public void verificaSeABuscaPorClientesComRendaMaiorQue2RetornaCodigoStatusOK () throws Exception {
        // Realize a requisição GET para "/clients/incomeGreaterThan2/{income}"
        ResultActions result = mockMvc.perform(get("/clients/incomeGreaterThan2/1500")
                .accept(MediaType.APPLICATION_JSON));

        // Verifique se o status da resposta é 200 (ok)
        result.andExpect(status().isOk());

        // Verifique se o corpo da resposta contém os atributos desejados
        result.andExpect(jsonPath("$.content").exists());
        result.andExpect(jsonPath("$.content[0].name").value("Carolina Maria de Jesus"));
        result.andExpect(jsonPath("$.content[1].name").value("Chimamanda Adichie"));
    }

    @Test
    public void verificaSeAtualizacaoDeClienteComIDExistenteEetornaCodigoStatusOK () throws Exception {
        // Id do cliente a ser atualizado
        Long clientId = 1L;

        // Crie um objeto ClientDTO com os dados que você deseja atualizar
        ClientDTO clientDTO = new ClientDTO(
                null,
                "Amanda",
                "123456789",
                5000.0,
                Instant.parse("1990-01-01T00:00:00Z"),
                2
        );

        // Converta o objeto ClientDTO para JSON
        String json = objectMapper.writeValueAsString(clientDTO);

        // Realize a requisição PUT para "/clients/{id}"
        ResultActions result = mockMvc.perform(put("/clients/{id}", clientId)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Verifique se o status da resposta é 200 (ok)
        result.andExpect(status().isOk());

        // Verifique se o corpo da resposta contém os atributos desejados
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").value("Amanda"));
    }



}