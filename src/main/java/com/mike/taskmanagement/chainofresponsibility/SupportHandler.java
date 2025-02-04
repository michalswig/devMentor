package com.mike.taskmanagement.chainofresponsibility;

import org.springframework.stereotype.Service;

@Service
public interface SupportHandler {
    void setNext(SupportHandler nextHandler);
    void handleRequest(String issue);

}
