package com.galvanize.employeeemail;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.employeeemail.models.EmailAddress;
import com.galvanize.employeeemail.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createAnEmployee() throws Exception {

        List<EmailAddress> emails =  new ArrayList<EmailAddress>();
        EmailAddress emailAddress =  EmailAddress.builder()
                                        .id(1L)
                                        .emailType("personal")
                                        .email("personal@gmail.com")
                                        .build();

        EmailAddress emailAddress1 =  EmailAddress.builder()
                                        .id(2L)
                                        .emailType("personal")
                                        .email("official@gmail.com")
                                        .build();

        emails.add(emailAddress);
        emails.add(emailAddress1);

        Employee employee = new Employee(1l,"firstName","lastName",emails);

        mockMvc.perform(post("/api/v1/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(employee)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.firstName").value("firstName"))
                        .andExpect(jsonPath("$.lastName").value("lastName"))
                        .andExpect(jsonPath("$.emails[0].email").value("personal@gmail.com"))
                        .andExpect(jsonPath("$.emails[1].email").value("official@gmail.com"));
    }


}
