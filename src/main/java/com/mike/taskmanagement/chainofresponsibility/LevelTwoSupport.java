package com.mike.taskmanagement.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelTwoSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        if (issue.contains("software installation")) {
            log.info("Level 2 Support: Handling software installation issue.");
        } else {
            log.info("Level 2 Support: Passing issue to Level 3.");
            passToNext(issue);
        }
    }

}
