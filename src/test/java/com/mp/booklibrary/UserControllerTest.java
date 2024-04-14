package com.mp.booklibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.enums.UserProfileType;
import com.mp.booklibrary.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserServiceImpl userService;

    private List<UserProfile> users = new ArrayList<>();

    @Test
    void contextLoads(){
        assertNotNull(mockMvc);
    }
    @BeforeEach
    void setup(){
        users.add(new UserProfile("USER ONE", "email_01@email.com", UserProfileType.BORROWER, true ));
        users.add(new UserProfile("USER TWO", "email_02@email.com", UserProfileType.BACKOFFICE, false ));
        for (UserProfile user : users)
        {
            userService.Save(user);
        }
    }

    @AfterEach
    void clear(){
    }

    @Test
    public void postUser() throws  Exception{
        UserDto newUser = new UserDto("new user", "email_03@gmail.com", true, 2);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String requestBody = objectMapper.writeValueAsString(newUser);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        mockMvc.perform(request)
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllTest() throws  Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/users")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()", greaterThan(0)));

    }
}
