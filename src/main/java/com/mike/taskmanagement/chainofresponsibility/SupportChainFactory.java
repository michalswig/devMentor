package com.mike.taskmanagement.chainofresponsibility;

import java.util.List;

public class SupportChainFactory {

    private SupportChainFactory() {
    }

    public static SupportHandler createChain(List<SupportHandler> handlers) {
        if (handlers.isEmpty()) {
            throw new IllegalArgumentException("Handler list cannot be empty.");
        }

        SupportHandler head = handlers.get(0);
        SupportHandler current = head;

        for (int i = 1; i < handlers.size(); i++) {
            current.setNext(handlers.get(i));
            current = handlers.get(i);
        }

        return head;
    }
}
