package com.goodfancier.searchEngine.Rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodfancier.searchEngine.Controller.ThemeController;
import com.goodfancier.searchEngine.Entity.Theme;
import com.goodfancier.searchEngine.Entity.QueryResult;
import com.goodfancier.searchEngine.Utils.WebListener;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation REST Client
 */
@Service
public class RestService implements IRestService
{

    private static Logger Logger = LogManager.getLogger(RestService.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    @Override
    public String sendRequest(String absoluteUri)
    {
        String jsonData = null;
        if (Objects.nonNull(absoluteUri))
        {
            HttpGet httpget = new HttpGet(absoluteUri);
            try (CloseableHttpResponse response = httpclient.execute(httpget))
            {
                if (response.getStatusLine().getStatusCode() != 200)
                {
                    throw new IOException(EntityUtils.toString(response.getEntity()));
                }
                List<Theme> list = getData(response);
                WebListener resp = new WebListener(list);
                jsonData = objectMapper.writeValueAsString(resp);
            } catch (Exception ex)
            {
                Logger.error("[SEND REST REQUEST] Error", ex);
            }
        }
        return jsonData;
    }

    private List<Theme> getData(CloseableHttpResponse response) throws IOException
    {
        QueryResult result = objectMapper.readValue(EntityUtils.toString(response.getEntity()), QueryResult.class);
        List<Theme> list = new ArrayList<>(5);
        for (Theme stack : result.getItems())
        {
            Theme theme = new Theme();
            theme.setAnswerCount(stack.getAnswerCount());
            theme.setCreation_date(stack.getCreation_date());
            theme.setName(stack.getOwner().getDisplay_name());
            theme.setTitle(stack.getTitle());
            theme.setLink(stack.getLink());
            list.add(theme);
        }
        return list;
    }
}