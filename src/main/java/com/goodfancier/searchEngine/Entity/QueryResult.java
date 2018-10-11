package com.goodfancier.searchEngine.Entity;

import java.util.List;

public class QueryResult
{
    private List<Theme> items;
    private Boolean has_more;
    private Integer quota_max;
    private Integer quota_remaining;

    public List<Theme> getItems() {
        return items;
    }

    public void setItems(List<Theme> items) {
        this.items = items;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public Integer getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(Integer quota_max) {
        this.quota_max = quota_max;
    }

    public Integer getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(Integer quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

}
