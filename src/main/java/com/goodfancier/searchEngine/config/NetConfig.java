package com.goodfancier.searchEngine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Find net configuration
 */
@Configuration
@ConfigurationProperties("netconfig")
public class NetConfig
{
    @Value("${net.host}")
    private String host;
    @Value("${net.useSsl}")
    private Boolean useSsl;
    @Value("${net.api}")
    private String api;
    @Value("${net.order}")
    private String order;
    @Value("${net.sort}")
    private String sort;
    @Value("${net.site}")
    private String site;

    public String getRequestUri()
    {
        String protocol = useSsl ? "https" : "http";
        return String.format("%s://%s/%s/search?order=%s&sort=%s&site=%s&intitle=", protocol, host, api, order, sort, site);
    }
}
