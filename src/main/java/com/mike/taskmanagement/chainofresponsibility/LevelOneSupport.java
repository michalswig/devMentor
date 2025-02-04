package com.mike.taskmanagement.chainofresponsibility;

public class LevelOneSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        if (issue.contains("password reset")) {
            System.out.println("Level 1 Support: Handling password reset issue.");
        } else {
            System.out.println("Level 1 Support: Passing issue to Level 2.");
            passToNext(issue);
        }
    }

}
