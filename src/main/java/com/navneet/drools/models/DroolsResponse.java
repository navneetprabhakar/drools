package com.navneet.drools.models;

import lombok.Data;

@Data
public class DroolsResponse {

    private String grade;
    private Integer marksObtained;
    private Integer total;
    private Double percentage;
}
