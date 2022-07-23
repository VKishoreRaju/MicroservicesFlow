package com.kr.poc.common.client;

import com.kr.poc.model.CityMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MasterDataClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.masterUrl}")
    private String masterURL;

    public CityMaster getCityMasterData(){
        log.info("=======>START OF MasterDataClient==>getCityMasterData<============");
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity =new HttpEntity(headers);

        ResponseEntity<CityMaster> response=restTemplate.postForEntity(masterURL,entity,CityMaster.class);
        CityMaster cityMaster=response.getBody();
        log.info("=======>EXITING MasterDataClient==>getCityMasterData<============");
        return cityMaster;

    }




}
