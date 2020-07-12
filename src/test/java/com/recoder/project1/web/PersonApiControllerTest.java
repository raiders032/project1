package com.recoder.project1.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.recoder.project1.domain.person.Person;
import com.recoder.project1.domain.person.PersonRepository;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonApiControllerTest {

    @Autowired private PersonApiController personApiController;
    @Autowired private WebApplicationContext context;
    @LocalServerPort private int port;
    @Autowired private PersonRepository personRepository;
    private MockMvc mvc;

    @Before
    public void setup(){
        mvc= MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    @WithMockUser(roles="USER")
    public void save_person_duplicate() throws Exception {
        //given
        PersonSaveRequestDto requestDto1 = PersonSaveRequestDto.builder()
                .email("nys1@naver.com")
                .nickname("kim")
                .build();
        PersonSaveRequestDto requestDto2 = PersonSaveRequestDto.builder()
                .email("nys1@naver.com")
                .nickname("kim2")
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts";

        //when
        mvc.perform(post("/api/v1/person")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto1)))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(status().isOk());

        mvc.perform(post("/api/v1/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto2)))
                .andExpect(jsonPath("$.id").isEmpty())
                .andDo(print())
                .andExpect(status().isOk());
        //then
        List<Person> all = personRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);

    }


}