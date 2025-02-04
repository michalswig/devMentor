package com.mike.taskmanagement.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class SupportChainFactoryTest {

    private SupportHandler level1;
    private SupportHandler level2;
    private SupportHandler level3;

    @BeforeEach
    void setUp() {
        // Create mock handlers
        level1 = mock(SupportHandler.class);
        level2 = mock(SupportHandler.class);
        level3 = mock(SupportHandler.class);
    }

    @Test
    void testCreateChain_ShouldCorrectlyLinkHandlers() {
        SupportHandler chain = SupportChainFactory.createChain(List.of(level1, level2, level3));

        verify(level1).setNext(level2);
        verify(level2).setNext(level3);
        verify(level3, never()).setNext(any());
    }

    @Test
    void testCreateChain_ThrowsExceptionOnEmptyList() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SupportChainFactory.createChain(List.of());
        });

        assertEquals("Handler list cannot be empty.", exception.getMessage());
    }

}