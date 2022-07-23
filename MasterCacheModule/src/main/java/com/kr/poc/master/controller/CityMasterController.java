package com.kr.poc.master.controller;

import com.kr.poc.master.model.CityMaster;
import com.kr.poc.master.service.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class CityMasterController {

    @Autowired
    private CityServiceImpl service;


    // Save a new City.
    // Url - http://localhost:10091/api/redis/employee
    @PostMapping
    public String save(@RequestBody final CityMaster employee) {
        log.info("Saving the new City to the redis.");
        service.save(employee);
        return "Successfully added. City with id= " + employee.getId();
    }

    // Get all Cities.
    // Url - http://localhost:10091/api/redis/employee/getall
    @GetMapping("/getall")
    public Map<String, CityMaster> findAll() {
        log.info("Fetching all City from the redis.");
        final Map<String, CityMaster> employeeMap = service.findAll();
        // Todo - If developers like they can sort the map (optional).
        return employeeMap;
    }

    // Get City by id.
    // Url - http://localhost:10091/api/redis/employee/get/<employee_id>
    @GetMapping("/get/{id}")
    public CityMaster findById(@PathVariable("id") final String id) {
        log.info("Fetching City with id= " + id);
        return service.findById(id);
    }

    // Delete City by id.
    // Url - http://localhost:10091/api/redis/employee/delete/<employee_id>
    @DeleteMapping("/delete/{id}")
    public Map<String, CityMaster> delete(@PathVariable("id") final String id) {
        log.info("Deleting City with id= " + id);
        // Deleting the City.
        service.delete(id);
        // Returning the all Cities (post the deleted one).
        return findAll();
    }

}
