package com.mike.taskmanagement.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelOneSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        if (issue.contains("password reset")) {
            log.info("Level 1 Support: Handling password reset issue.");
        } else {
            log.info("Level 1 Support: Passing issue to Level 2.");
            passToNext(issue);
        }
    }

}
