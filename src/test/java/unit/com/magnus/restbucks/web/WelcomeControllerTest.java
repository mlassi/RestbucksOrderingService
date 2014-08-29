package com.magnus.restbucks.web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Configuration
@WebAppConfiguration
public class WelcomeControllerTest {

  @InjectMocks
  private WelcomeController welcomeController;
  
  private MockMvc mockMvc;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
  }
  
  @Test
  public void givenRootUrl_thenReturnStatusOK() throws Exception {
    mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
  }
}
