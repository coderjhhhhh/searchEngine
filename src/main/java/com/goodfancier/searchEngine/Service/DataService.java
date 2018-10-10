package com.goodfancier.searchEngine.Service;

import com.goodfancier.searchEngine.Repository.IDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("dataService")
public class DataService implements IDataService
{
    private static final Logger LOG = LoggerFactory.getLogger(DataService.class);

    @Autowired
    @Qualifier("dataRepository")
    private IDataRepository dataRepository;

    @Override
    public boolean persist(String problem)
    {
        /*
        try {
            dataRepository.persist(new Data(UUID.randomUUID(), problem));
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
        */
        return true;
    }

    @Override
    public Set<String> getRandomData()
    {
        return dataRepository.getRandomData();
    }
}
