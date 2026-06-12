package de.htw_berlin.reisetagebuch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReiseController.class)
class ReiseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CountryService service;

    @Test
    void getCountriesReturns200AndJson() throws Exception {
        when(service.getAll()).thenReturn(List.of(new VisitedCountry("Japan", "JP")));

        mockMvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
