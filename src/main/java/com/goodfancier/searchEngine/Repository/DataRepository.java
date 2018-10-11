package com.goodfancier.searchEngine.Repository;

import com.goodfancier.searchEngine.Entity.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Repository("dataRepository")
public class DataRepository implements IDataRepository<Theme>
{

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Theme object)
    {
/*
        Object[] params = new Object[] { object.getId(), object.getDescription() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
        jdbcOperations.update("UPDATE stocks SET Name = \"saas\" WHERE stocks.RecID = 138;");
        */
    }

    @Override
    public void delete(Theme object)
    {
        jdbcOperations.update("DELETE FROM stocks WHERE RecID = 138;");
    }

    @Override
    public Set<String> getRandomData()
    {
        Set<String> result = new HashSet<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT * FROM stocks;");
        while (rowSet.next())
        {
            result.add(rowSet.toString());
        }
        return result;
    }


}
