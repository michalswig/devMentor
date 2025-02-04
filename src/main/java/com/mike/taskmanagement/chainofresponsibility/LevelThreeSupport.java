package com.mike.taskmanagement.chainofresponsibility;

public class LevelThreeSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        System.out.println("Level 3 Support: Handling complex issue.");
    }

}
