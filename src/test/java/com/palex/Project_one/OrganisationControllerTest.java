package com.palex.Project_one;


import com.palex.practice.controller.OrganisationController;
import com.palex.practice.dao.OrganisationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganisationController.class)   //создаем тестовое окружение с настроенным SpringMVC и Jackson
public class OrganisationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrganisationDao organisationDao;

    @Test
    public void whenValidInput_thenReturn200andDataSuccess() throws Exception {
        mockMvc.perform(get("/api/organisation/", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));
        verify(organisationDao, times(1)).getById(1L);
    }

    //@Test
    //public void whenValidPostInput_thenReturn200andResultData() throws Exception {
//
    //    OrganisationEntity organisationEntity = new OrganisationEntity();
//
    //    mockMvc.perform(
    //            post("/api/organisation/save")
    //            .content(Json)
    //                    .contentType(MediaType.APPLICATION_JSON)
    //                    .accept(MediaType.APPLICATION_JSON))
    //            .andExpect(status().isCreated())
    //            .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
//
//
//
//
    //    );
//
//
    //}


}
