package com.navneet.drools.models;

import lombok.Data;

/**
 * @author navneetprabhakar
 */
@Data
public class DroolsResponse {

    private String grade;
    private Integer marksObtained;
    private Integer total;
    private Double percentage;
}
