package com.goodfancier.searchEngine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodfancier.searchEngine.Entity.QueryResult;
import com.goodfancier.searchEngine.Rest.RestService;
import com.goodfancier.searchEngine.config.NetConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SearchEngineTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private RestService rest;
    @Autowired
    private NetConfig config;


    @Before
    public void before() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void shouldReturnConfig() {
        Assert.assertNotNull(config.getRequestUri());
    }

    @Test
    public void shouldReturnNullWhenNullUri() {
        assertNull(rest.sendRequest(null));
    }

    @Test
    public void shouldReturnIndex() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
        ResultActions result = mvc.perform(request);
        result.andExpect(status().isOk());
        result.andExpect(forwardedUrl("index"));
    }

    @Test
    public void shouldReturnStackResponse() throws Exception {
        String json = readJson("src/test/resources/test.json");
        ObjectMapper objectMapper = new ObjectMapper();
        QueryResult result = objectMapper.readValue(json, QueryResult.class);

        result.getItems().forEach(i -> assertNotNull(i));
        assertNotNull(result.getHas_more());
        assertNotNull(result.getItems());
        assertNotNull(result.getQuota_max());
        assertNotNull(result.getQuota_remaining());
    }

    private static String readJson(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}
