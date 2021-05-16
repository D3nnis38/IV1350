package tests.view;


import controller.Controller;
import dbHandler.DBHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    private View instanceToTest;
    private DBHandler dbHandler;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        dbHandler = new DBHandler();
        System.setOut(inMemSysOut);
        Controller contr = new Controller(dbHandler);
        instanceToTest = new View(contr);
    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
        Controller contr = null;
        instanceToTest = null;
    }

    @Test
    public void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("started"), "UI did not start correctly.");
    }

}
