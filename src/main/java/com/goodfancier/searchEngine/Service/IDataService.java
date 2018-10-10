package com.goodfancier.searchEngine.Service;

import java.util.Set;

public interface IDataService
{
    public boolean persist(String problem);

    public Set<String> getRandomData();
}
