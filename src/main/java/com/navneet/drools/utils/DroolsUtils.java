package com.navneet.drools.utils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This Utility class contains util methods related to Drool and KIE
 * @author navneetprabhakar
 *
 */
@Component
public class DroolsUtils {

    @Autowired
    private KieContainer kieContainer;

    /**This method executes 2 param rule engine
     * @param score
     * @param request
     * @param session
     * @return
     */
    public <T,K> T executeRuleEngine(T score,K request, String session) {
        KieSession kieSession = kieContainer.newKieSession(session);
        kieSession.insert(score);
        kieSession.insert(request);
        kieSession.fireAllRules();
        kieSession.dispose();
        return score;
    }

    /**This method executes 3 param rule engine
     * @param score
     * @param request
     * @param threshold
     * @param session
     * @return
     */
    public <T,K,M> T executeRuleEngine(T score,K request,M threshold, String session) {
        KieSession kieSession = kieContainer.newKieSession(session);
        kieSession.insert(score);
        kieSession.insert(request);
        kieSession.insert(threshold);
        kieSession.fireAllRules();
        kieSession.dispose();
        return score;
    }

}
