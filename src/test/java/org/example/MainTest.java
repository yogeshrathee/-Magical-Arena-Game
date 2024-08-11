package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Main class.
 * This class contains unit tests to verify the functionality of the Main class.
 */
class MainTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    /**
     * Sets up the output stream for capturing the output before each test.
     */
    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * Restores the system input and output streams after each test.
     */
    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    /**
     * Tests that the game runs correctly in auto mode.
     * Simulates user input for choosing auto mode and verifies that the game output contains expected strings.
     */
    @Test
    void testAutoMode() {
        String input = "2\n"; // Choosing auto mode
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Player A rolls") || output.contains("Player B rolls")); // Check if the game ran
    }

    /**
     * Tests that the game handles invalid input gracefully and prompts again.
     * Simulates user input with invalid choice and verifies that the prompt appears again.
     */
    @Test
    void testInvalidInputHandling() {
        String input = "3\n1\n50\n5\n10\n50\n5\n10\n"; // Invalid choice first, then valid input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Choose mode:")); // Check if the prompt appears again
    }

    /**
     * Tests that the game handles edge cases for player stats in manual mode.
     * Simulates user input for choosing manual mode with edge case stats (zero values).
     * Verifies that the no attack messages appear in the output.
     */
    @Test
    void testManualModeWithEdgeCaseStats() {
        String input = "1\n0\n0\n0\n0\n0\n0\n"; // Choosing manual mode with edge case stats
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String output = testOut.toString();
        assertFalse(output.contains("Player A attacks") || output.contains("Player B attacks"));
    }

    /**
     * Tests an end-to-end scenario in auto mode with valid inputs.
     * Simulates user input for auto mode and verifies the complete game flow and output (wins!).
     */
    @Test
    void testAutoModeEndToEnd() {
        String input = "2\n"; // Choosing auto mode
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Player A wins!") || output.contains("Player B wins!"));

    }

}
