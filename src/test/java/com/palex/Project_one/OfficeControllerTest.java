package com.palex.Project_one;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palex.practice.Application;
import com.palex.practice.controller.OfficeController;
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
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class OfficeControllerTest {

    @Autowired
    ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private OfficeController officeController;
    @InjectMocks
    private OrganisationController organisationController;

    @Test
    public void whenSaveNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenSaveValidAllDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidNotRequiresDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111222222\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }


    @Test
    public void whenSaveValidRequiresDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));
    }

    @Test
    public void whenSaveInvalidRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"qwe\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenSaveEmptyRequiesDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenGetIdValidInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));


        this.mockMvc.perform(get("/api/office/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.name").isNotEmpty())
                .andExpect(jsonPath("$.data.address").isNotEmpty())
                .andExpect(jsonPath("$.data.isActive").isNotEmpty());
    }


    @Test
    public void whenListNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenValidListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\"}";
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        String jsonString = "{\"orgId\":\"100\",\"name\":\"\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void whenInvalidListRequiredDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":null,\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice2\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("1"))
                .andExpect(jsonPath("$.data[0].name").value("TestOffice"))
                .andExpect(jsonPath("$.data[0].isActive").value("true"))
                .andExpect(jsonPath("$.data[1].id").value("2"))
                .andExpect(jsonPath("$.data[1].name").value("TestOffice2"))
                .andExpect(jsonPath("$.data[1].isActive").value("true"));
    }

    @Test
    public void whenValidDataInputWithSpecifyParametrListDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice2\",\"address\":\"TestOfficeAddress\",\"phone\":\"+7985222222\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"\",\"phone\":\"+7985222222\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("2"))
                .andExpect(jsonPath("$.data[0].name").value("TestOffice2"))
                .andExpect(jsonPath("$.data[0].isActive").value("true"));
    }

    @Test
    public void whenUpdateNoBodyDataInput_thenReturn400AndError() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenGetNotExistingDataInput_thenReturn200andResultNull() throws Exception {
        this.mockMvc.perform(get("/api/user/100").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void whenUpdateValidAllDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"1\",\"name\":\"NewTestOffice\",\"address\":\"NewTestOfficeAddress\",\"phone\":\"+79850000000\",\"isActive\":\"false\"}";
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.result").value("success"));

        this.mockMvc.perform(get("/api/office/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("NewTestOffice"))
                .andExpect(jsonPath("$.data.address").value("NewTestOfficeAddress"))
                .andExpect(jsonPath("$.data.phone").value("+79850000000"))
                .andExpect(jsonPath("$.data.isActive").value("false"));
    }

    @Test
    public void whenUpdateInvalidNotRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"1\",\"name\":\"NewTestOffice\",\"address\":\"NewTestOfficeAddress\",\"phone\":\"+79850000000000000000000000000000\",\"isActive\":\"false\"}";
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));

        this.mockMvc.perform(get("/api/office/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("TestOffice"))
                .andExpect(jsonPath("$.data.address").value("TestOfficeAddress"))
                .andExpect(jsonPath("$.data.phone").value("+79851111111"))
                .andExpect(jsonPath("$.data.isActive").value("true"));
    }

    @Test
    public void whenUpdateInvalidRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"qwe\",\"name\":null,\"address\":\"NewTestOfficeAddress\",\"phone\":\"+79850000000\",\"isActive\":\"false\"}";
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));

        this.mockMvc.perform(get("/api/office/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("TestOffice"))
                .andExpect(jsonPath("$.data.address").value("TestOfficeAddress"))
                .andExpect(jsonPath("$.data.phone").value("+79851111111"))
                .andExpect(jsonPath("$.data.isActive").value("true"));
    }
}
