package com.github.mgljava.controller;

import com.alibaba.fastjson.JSON;
import com.github.mgljava.service.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class HelloControllerTest {

  @Autowired
  HelloService helloService;
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(new HelloController(helloService)).build();
  }

  @Test
  public void testHelloInterface() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello")
        .contentType(MediaType.APPLICATION_JSON)
        .param("word", "Zhangsan")
        .content(JSON.toJSONString(null));

    MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

    int status = mvcResult.getResponse().getStatus();
    String content = mvcResult.getResponse().getContentAsString();

    System.out.println(status);
    System.out.println(content);
  }
}
