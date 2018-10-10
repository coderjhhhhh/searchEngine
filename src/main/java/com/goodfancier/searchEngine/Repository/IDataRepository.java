package com.goodfancier.searchEngine.Repository;

import com.goodfancier.searchEngine.Entity.DomainObject;

import java.util.Set;

public interface IDataRepository<V extends DomainObject>
{

    void persist(V object);

    void delete(V object);

    Set<String> getRandomData();

}
