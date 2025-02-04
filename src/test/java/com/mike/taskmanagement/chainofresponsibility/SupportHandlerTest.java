package com.mike.taskmanagement.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SupportHandlerTest {

    private SupportHandler chain;  // The head of the support chain
    private ByteArrayOutputStream outputStream;  // get System.out output

    @BeforeEach
    void setUp() {
        // console output instead of printing to terminal
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        chain = SupportChainFactory.createChain(
                List.of(new LevelOneSupport(), new LevelTwoSupport(), new LevelThreeSupport())
        );
    }

    @Test
    void testPasswordResetHandledByLevelOne() {
        chain.handleRequest("password reset");

        String output = outputStream.toString();
        assertTrue(output.contains("Level 1 Support: Handling password reset issue."));
    }

    @Test
    void testSoftwareInstallationHandledByLevelTwo() {
        chain.handleRequest("software installation");

        String output = outputStream.toString();
        assertTrue(output.contains("Level 1 Support: Passing issue to Level 2."));
        assertTrue(output.contains("Level 2 Support: Handling software installation issue."));
    }

    @Test
    void testServerCrashHandledByLevelThree() {
        chain.handleRequest("server crash");

        String output = outputStream.toString();
        assertTrue(output.contains("Level 1 Support: Passing issue to Level 2."));
        assertTrue(output.contains("Level 2 Support: Passing issue to Level 3."));
        assertTrue(output.contains("Level 3 Support: Handling complex issue."));
    }

    @Test
    void testUnknownIssueHandledByLevelThree() {
        chain.handleRequest("unknown issue");

        String output = outputStream.toString();
        assertTrue(output.contains("Level 1 Support: Passing issue to Level 2."));
        assertTrue(output.contains("Level 2 Support: Passing issue to Level 3."));
        assertTrue(output.contains("Level 3 Support: Handling complex issue."));
    }
}
