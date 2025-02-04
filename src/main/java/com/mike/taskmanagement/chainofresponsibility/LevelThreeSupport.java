package com.mike.taskmanagement.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelThreeSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        log.info("Level 3 Support: Handling complex issue.");
    }

}
