package com.goodfancier.searchEngine.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodfancier.searchEngine.Rest.RestService;
import com.goodfancier.searchEngine.config.NetConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThemeController extends ExceptionHandlerController
{
    @Autowired
    private RestService rest;

    @Autowired
    private NetConfig config;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @PostMapping("/getResult")
    @ResponseBody
    public String getResult(@RequestBody String title)
    {
        String json = rest.sendRequest(
                new StringBuilder().append(config.getRequestUri()).append(title).toString());
        return json;
    }
}
