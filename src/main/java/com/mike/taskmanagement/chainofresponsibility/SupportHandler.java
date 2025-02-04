package com.mike.taskmanagement.chainofresponsibility;

public interface SupportHandler {
    void setNext(SupportHandler nextHandler);
    void handleRequest(String issue);

}
