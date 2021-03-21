package com.navneet.drools.controller;

import com.navneet.drools.models.DroolsRequest;
import com.navneet.drools.models.DroolsResponse;
import com.navneet.drools.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/rules/")
public class DroolsController {

    @Autowired
    private DroolsService droolsService;


    @PostMapping("calculateResult")
    public DroolsResponse calculateResult(@RequestBody DroolsRequest request) {
        return droolsService.calcaulateResult(request);
    }

}
