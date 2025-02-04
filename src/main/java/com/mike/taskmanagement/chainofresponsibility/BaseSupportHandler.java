package com.mike.taskmanagement.chainofresponsibility;

abstract class BaseSupportHandler implements SupportHandler {

    private SupportHandler nextHandler;

    @Override
    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void passToNext(String issue) {
        if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        }
    }

}
