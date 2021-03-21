package com.navneet.drools.models;

import lombok.Data;

import java.util.List;

@Data
public class DroolsRequest {
    private List<DataSet> marksheet;


    @Data
    public static class DataSet{
        private String subject;
        private Integer marks;
        private Integer totalMarks;
    }
}
