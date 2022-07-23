package com.kr.poc.master.service;


import com.kr.poc.master.model.CityMaster;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Data
public class CityServiceImpl {

    private final String CITY_CACHE = "CITY";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, CityMaster> hashOperations;

    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    // Save operation.
    //@Override
    public void save(final CityMaster cityMaster) {
        hashOperations.put(CITY_CACHE, cityMaster.getId(), cityMaster);
    }

    // Find by employee id operation.
    //@Override
    public CityMaster findById(final String id) {
        return (CityMaster) hashOperations.get(CITY_CACHE, id);
    }

    // Find all employees' operation.
    //@Override
    public Map<String, CityMaster> findAll() {
        return hashOperations.entries(CITY_CACHE);
    }

    // Delete employee by id operation.
    //@Override
    public void delete(String id) {
        hashOperations.delete(CITY_CACHE, id);
    }

}
