package com.kr.poc.master.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class CityMaster implements Serializable {

    private String id;
    private String cityName;
    private String cityCode;


}
