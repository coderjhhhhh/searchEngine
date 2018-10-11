package com.goodfancier.searchEngine.Utils;

import com.goodfancier.searchEngine.Entity.Theme;

import java.util.List;

public class WebListener
{
    private List<Theme> items;

    public WebListener(List<Theme> items) {
        this.items = items;
    }

    public List<Theme> getItems()
    {
        return items;
    }

    public void setItems(List<Theme> items)
    {
        this.items = items;
    }
}
