package com.palex.Project_one;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palex.practice.Application;
import com.palex.practice.controller.OrganisationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
//@WebMvcTest
public class OrganisationControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private OrganisationController organisationController;

    @Test
    public void whenSaveValidAllDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidNotRequiresDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"qwe\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }


    @Test
    public void whenSaveValidRequiresDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"111111111100000000000000000\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenSaveEmptyRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }


    @Test
    public void whenGetIdValidInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.name").isNotEmpty())
                .andExpect(jsonPath("$.data.fullName").isNotEmpty())
                .andExpect(jsonPath("$.data.inn").isNotEmpty())
                .andExpect(jsonPath("$.data.kpp").isNotEmpty())
                .andExpect(jsonPath("$.data.address").isNotEmpty())
                .andExpect(jsonPath("$.data.isActive").isNotEmpty());
    }

    @Test
    public void whenGetNotExistingDataInput_thenReturn200andResultNull() throws Exception {
        this.mockMvc.perform(get("/api/organisation/100").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void whenValidListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[*].id").isNotEmpty())
                .andExpect(jsonPath("$.data[*].name").isNotEmpty())
                .andExpect(jsonPath("$.data[*].isActive").isNotEmpty());
    }

    @Test
    public void whenValidNotExistingListDataInput_thenReturn200andResultSuccessAndEmptyData() throws Exception {

        String jsonString = "{\"name\":\"HPE\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void whenInvalidListRequiredDataInput_thenReturn400andError() throws Exception {
        String jsonString = "{\"name\":\"\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenValidMultipleListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));
        jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("1"))
                .andExpect(jsonPath("$.data[0].name").value("Test"))
                .andExpect(jsonPath("$.data[0].isActive").value("true"))
                .andExpect(jsonPath("$.data[1].id").value("2"))
                .andExpect(jsonPath("$.data[1].name").value("Test"))
                .andExpect(jsonPath("$.data[1].isActive").value("true"));
    }

    @Test
    public void whenValidDataInputWithSpecifyParametrListDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));
        jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"1111111111\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("1"))
                .andExpect(jsonPath("$.data[0].name").value("Test"))
                .andExpect(jsonPath("$.data[0].isActive").value("true"));
    }


    @Test
    public void whenSaveValidAllDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidNotRequiresDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"qwe\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }


    @Test
    public void whenSaveValidRequiresDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"111111111100000000000000000\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenSaveEmptyRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }


    @Test
    public void whenGetIdValidInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.name").isNotEmpty())
                .andExpect(jsonPath("$.data.fullName").isNotEmpty())
                .andExpect(jsonPath("$.data.inn").isNotEmpty())
                .andExpect(jsonPath("$.data.kpp").isNotEmpty())
                .andExpect(jsonPath("$.data.address").isNotEmpty())
                .andExpect(jsonPath("$.data.isActive").isNotEmpty());
    }




}
