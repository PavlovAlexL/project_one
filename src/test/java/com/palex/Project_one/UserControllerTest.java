package com.palex.Project_one;

import com.palex.practice.Application;
import com.palex.practice.ResultDataAdvice;
import com.palex.practice.controller.OfficeController;
import com.palex.practice.controller.OrganisationController;
import com.palex.practice.controller.UserController;
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
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private OfficeController officeController;

    @InjectMocks
    private OrganisationController organisationController;

    @InjectMocks
    private ResultDataAdvice resultDataAdvice;

    @Test
    public void whenSaveNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8))
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
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+7985555555500000000000000\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8)
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
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"position\":\"Manager\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":null,\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8)
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

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(get("/api/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.firstName").isNotEmpty())
                .andExpect(jsonPath("$.data.lastName").isNotEmpty())
                .andExpect(jsonPath("$.data.middleName").isNotEmpty())
                .andExpect(jsonPath("$.data.position").isNotEmpty())
                .andExpect(jsonPath("$.data.phone").isNotEmpty())
                .andExpect(jsonPath("$.data.docName").isNotEmpty())
                .andExpect(jsonPath("$.data.docNumber").isNotEmpty())
                .andExpect(jsonPath("$.data.docDate").isNotEmpty())
                .andExpect(jsonPath("$.data.citizenshipName").isNotEmpty())
                .andExpect(jsonPath("$.data.citizenshipCode").isNotEmpty())
                .andExpect(jsonPath("$.data.isIdentified").isNotEmpty());
    }

    @Test
    public void whenListNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8))
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

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\"}";
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[*].id").isNotEmpty())
                .andExpect(jsonPath("$.data[*].firstName").isNotEmpty())
                .andExpect(jsonPath("$.data[*].lastName").isNotEmpty())
                .andExpect(jsonPath("$.data[*].middleName").isNotEmpty())
                .andExpect(jsonPath("$.data[*].position").isNotEmpty());
    }

    @Test
    public void whenValidNotExistingListDataInput_thenReturn200andResultSuccessAndEmptyData() throws Exception {

        String jsonString = "{\"officeId\":\"1\"}";

        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void whenInvalidListRequiredDataInput_thenReturn400andError() throws Exception {

        String jsonString = "{\"officeId\":null}";

        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));
    }

    @Test
    public void whenValidMultipleListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName2\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\"}";

        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("1"))
                .andExpect(jsonPath("$.data[0].firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.data[0].lastName").value("TestLastName"))
                .andExpect(jsonPath("$.data[0].middleName").value("TestMiddleName"))
                .andExpect(jsonPath("$.data[0].position").value("Manager"))
                .andExpect(jsonPath("$.data[1].id").value("2"))
                .andExpect(jsonPath("$.data[1].firstName").value("TestFirstName2"))
                .andExpect(jsonPath("$.data[1].lastName").value("TestLastName"))
                .andExpect(jsonPath("$.data[1].middleName").value("TestMiddleName"))
                .andExpect(jsonPath("$.data[1].position").value("Manager"));
    }

    @Test
    public void whenValidDataInputWithSpecifyParametrListDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName2\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName2\"}";

        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("2"))
                .andExpect(jsonPath("$.data[0].firstName").value("TestFirstName2"))
                .andExpect(jsonPath("$.data[0].lastName").value("TestLastName"))
                .andExpect(jsonPath("$.data[0].middleName").value("TestMiddleName"))
                .andExpect(jsonPath("$.data[0].position").value("Manager"));
    }


    @Test
    public void whenUpdateNoBodyDataInput_thenReturn400AndError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON_UTF8))
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

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"id\":\"1\",\"officeId\":\"1\",\"firstName\":\"NewTestFirstName\",\"lastName\":\"NewTestLastName\",\"middleName\":\"NewTestMiddleName\",\"position\":\"Admmin\",\"phone\":\"+79857777777\",\"docName\":\"Test Document\",\"docNumber\":\"987654321\",\"docDate\":\"02.02.2010\",\"citizenshipCode\":\"804\",\"isIdentified\":\"false\"}";
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        this.mockMvc.perform(get("/api/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.firstName").value("NewTestFirstName"))
                .andExpect(jsonPath("$.data.lastName").value("NewTestLastName"))
                .andExpect(jsonPath("$.data.middleName").value("NewTestMiddleName"))
                .andExpect(jsonPath("$.data.position").value("Admmin"))
                .andExpect(jsonPath("$.data.phone").value("+79857777777"))
                .andExpect(jsonPath("$.data.docName").value("Test Document"))
                .andExpect(jsonPath("$.data.docNumber").value("987654321"))
                .andExpect(jsonPath("$.data.docDate").value("2010-02-02"))
                .andExpect(jsonPath("$.data.citizenshipName").value("УКРАИНА"))
                .andExpect(jsonPath("$.data.citizenshipCode").value("804"))
                .andExpect(jsonPath("$.data.isIdentified").value("false"));
    }

    @Test
    public void whenUpdateInvalidNotRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"id\":\"1\",\"officeId\":\"1\",\"firstName\":\"NewTestFirstName\",\"lastName\":\"NewTestLastName\",\"middleName\":\"NewTestMiddleName\",\"position\":\"Admmin\",\"phone\":\"+79857777777000000000000000\",\"docName\":\"Test Document\",\"docNumber\":\"987654321\",\"docDate\":\"02.02.2010\",\"citizenshipCode\":\"804\",\"isIdentified\":\"false\"}";
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));

        this.mockMvc.perform(get("/api/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.data.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.data.middleName").value("TestMiddleName"))
                .andExpect(jsonPath("$.data.position").value("Manager"))
                .andExpect(jsonPath("$.data.phone").value("+79855555555"))
                .andExpect(jsonPath("$.data.docNumber").value("123456789"))
                .andExpect(jsonPath("$.data.docDate").value("2000-07-01"))
                .andExpect(jsonPath("$.data.citizenshipCode").value("643"))
                .andExpect(jsonPath("$.data.isIdentified").value("true"));
    }

    @Test
    public void whenUpdateInvalidRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"orgId\":\"1\",\"name\":\"TestOffice\",\"address\":\"TestOfficeAddress\",\"phone\":\"+79851111111\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"officeId\":\"1\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"middleName\":\"TestMiddleName\",\"position\":\"Manager\",\"phone\":\"+79855555555\",\"docCode\":\"07\",\"docName\":\"Военный билет\",\"docNumber\":\"123456789\",\"docDate\":\"01.07.2000\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}";
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString)).andExpect(status().isOk());

        jsonString = "{\"id\":\"1\",\"officeId\":\"1\",\"firstName\":\"NewTestFirstName\",\"lastName\":\"NewTestLastName\",\"middleName\":\"NewTestMiddleName\",\"position\":nullrk ,\"phone\":\"+79857777777000000000000000\",\"docName\":\"Test Document\",\"docNumber\":\"987654321\",\"docDate\":\"02.02.2010\",\"citizenshipCode\":\"804\",\"isIdentified\":\"false\"}";
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Error occured"));

        this.mockMvc.perform(get("/api/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.data.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.data.middleName").value("TestMiddleName"))
                .andExpect(jsonPath("$.data.position").value("Manager"))
                .andExpect(jsonPath("$.data.phone").value("+79855555555"))
                .andExpect(jsonPath("$.data.docNumber").value("123456789"))
                .andExpect(jsonPath("$.data.docDate").value("2000-07-01"))
                .andExpect(jsonPath("$.data.citizenshipCode").value("643"))
                .andExpect(jsonPath("$.data.isIdentified").value("true"));
    }
}

