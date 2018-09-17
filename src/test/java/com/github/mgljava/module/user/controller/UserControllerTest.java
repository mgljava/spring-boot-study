package com.github.mgljava.module.user.controller;

import com.github.mgljava.module.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserControllerTest {

  private MockMvc mockMvc;

  RequestBuilder requestBuilder = null;

  @Mock
  private UserService userService;

  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
  }

  @Test
  public void should_test_pass_all_user_object() throws Exception {
    requestBuilder = get("/users/");
    mockMvc.perform(requestBuilder)
        .andExpect(status().isOk()).andReturn().getResponse().getStatus();

    requestBuilder = post("/users/")
        .param("id", "1")
        .param("name", "Hello World")
        .param("age", "20");
    mockMvc.perform(requestBuilder)
        .andExpect(content().string(equalTo("success")));

    /*requestBuilder = get("/users/");
    mockMvc.perform(requestBuilder)
        .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"Hello World\",\"age\":20}]")));*/

    requestBuilder = put("/users/1")
        .param("name", "Monk")
        .param("age", "30");
    mockMvc.perform(requestBuilder)
        .andExpect(content().string(equalTo("success")));

    /*requestBuilder = get("/users/");
    mockMvc.perform(requestBuilder)
        .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"Monk\",\"age\":30}]")));*/

    requestBuilder = delete("/users/1");
    mockMvc.perform(requestBuilder)
        .andExpect(content().string(equalTo("success")));

    // 7、get查一下user列表，应该为空
    requestBuilder = get("/users/");
    mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("[]")));
  }
}
