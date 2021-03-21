package com.navneet.drools.service.impl;

import com.navneet.drools.constants.DroolsConstants;
import com.navneet.drools.models.DroolsRequest;
import com.navneet.drools.models.DroolsResponse;
import com.navneet.drools.service.DroolsService;
import com.navneet.drools.utils.DroolsUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Service
@Log4j2
public class DroolsServiceImpl implements DroolsService {
    @Autowired
    private DroolsUtils droolsUtils;

    @Override
    public DroolsResponse calcaulateResult(DroolsRequest request) {
        log.info("initiating calculate result");
        return droolsUtils.executeRuleEngine(new DroolsResponse(), request, DroolsConstants.SAMPLE.getSession());
    }

}
