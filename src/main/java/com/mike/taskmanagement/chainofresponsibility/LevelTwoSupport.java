package com.mike.taskmanagement.chainofresponsibility;

public class LevelTwoSupport extends BaseSupportHandler {

    @Override
    public void handleRequest(String issue) {
        if (issue.contains("software installation")) {
            System.out.println("Level 2 Support: Handling software installation issue.");
        } else {
            System.out.println("Level 2 Support: Passing issue to Level 3.");
            passToNext(issue);
        }
    }

}
