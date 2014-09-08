package com.magnus.restbucks.web;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.builder.EntityBuilder;
import com.magnus.restbucks.assembler.WelcomeResourceAssembler;
import com.magnus.restbucks.test.builder.WelcomeAssemblerMother;

@Configuration
@WebAppConfiguration
public class WelcomeControllerTest {

  @Mock
  private WelcomeResourceAssembler assemblerMock;

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
    Entity entity = EntityBuilder.newInstance().build();
    when(assemblerMock.toEntity()).thenReturn(entity);
    mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void givenRootUrl_thenReturnLinkToSelf() throws Exception {
    Entity rootLinksEntity = WelcomeAssemblerMother.getRootLinksEntity();
    when(assemblerMock.toEntity()).thenReturn(rootLinksEntity);
    mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.links[0].rel[0].", is("self")));

    verify(assemblerMock, times(1)).toEntity();
    verifyNoMoreInteractions(assemblerMock);
  }

  @Test
  public void givenRootUrl_thenReturnLinkToOrder() throws Exception {
    Entity rootLinksEntity = WelcomeAssemblerMother.getRootLinksEntity();
    when(assemblerMock.toEntity()).thenReturn(rootLinksEntity);
    mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.links[1].rel[0].", is("order")));

    verify(assemblerMock, times(1)).toEntity();
    verifyNoMoreInteractions(assemblerMock);
  }
}
