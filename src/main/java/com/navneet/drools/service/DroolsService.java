package com.navneet.drools.service;

import com.navneet.drools.models.DroolsRequest;
import com.navneet.drools.models.DroolsResponse;

/**
 * Service Interface for Drools Related Service APIs
 * @author navneetprabhakar
 *
 */
public interface DroolsService {

    /**
     * This method calculates DroolsResponse based on the request and the rules written for that session
     * @param request
     * @return
     */
    DroolsResponse calcaulateResult(DroolsRequest request);
}
