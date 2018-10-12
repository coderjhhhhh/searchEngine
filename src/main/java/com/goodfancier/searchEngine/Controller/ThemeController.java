package com.goodfancier.searchEngine.Controller;

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

    @PostMapping("/getResult")
    @ResponseBody
    public String getResult(@RequestBody String title)
    {
        return rest.sendRequest(config.getRequestUri() + title);
    }
}
