package com.example.denis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Test
    void start() throws Exception {

         mockMvc.perform(MockMvcRequestBuilders.get("/start"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

    }

    @Test
    void quess() throws Exception {

        playerService.start();
        playerService.start();

        Map<String,String > parameters = new HashMap<>();
        parameters.put("session" , "1");
        parameters.put("number", "5");

        ObjectMapper objectMapper = new ObjectMapper();
         mockMvc.perform(MockMvcRequestBuilders.post("/quess")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(parameters)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());


    }

    @Test
    void highscores() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/highscores"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
}