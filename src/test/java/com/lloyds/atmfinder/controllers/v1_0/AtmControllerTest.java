package com.lloyds.atmfinder.controllers.v1_0;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class AtmControllerTest {

    private URI uri = URI.create("http://localhost:8000");


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAtmControllerTestWithInvalidID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms/v1.0/test")
                    .param("uri", (String) null))
                    .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void getAtmControllerTestWithValidID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms/v1.0/LC3ACC11")
                .param("uri", (String) null))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.Identification").value("LC3ACC11"))
                .andExpect(jsonPath("$.Location.PostalAddress.PostCode").value("KT13 8DA"))
                .andExpect(jsonPath("$.Location.PostalAddress.TownName").value("WEYBRIDGE"))
                .andExpect(jsonPath("$.Location.PostalAddress.StreetName").value("1C CHURCH STREET"));

    }

    @Test
    public void getAtmControllerTestWithInvalidUri() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms/v1.0/LC3ACC11")
                .param("uri", "some/invalid/url"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("URI is not absolute"));
    }

    @Test
    public void getAtmControllerTestWithUnreachableUri() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms/v1.0/LC3ACC11")
                .param("uri", uri.toString()))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(Matchers.containsString("Connection refused")));
    }
}
