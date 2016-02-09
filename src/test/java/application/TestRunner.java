package application;

import io.JsonServiceTest;
import io.MessageTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Main test class for all the specified tests
 * @author sscerbatiuc
 */
public class TestRunner {
    public static void main(String[] args){
        System.out.println("Testing Json Service");
        Result testResult = JUnitCore.runClasses(JsonServiceTest.class);
        for (Failure testFailure : testResult.getFailures()){
            System.out.println(testFailure.toString());
        }

        System.out.println("Test Successful: " + testResult.wasSuccessful());

        System.out.println("Testing Message Parsing");
        Result messageParseTestResult = JUnitCore.runClasses(MessageTest.class);
        int i = 0;
        for (Failure testFailure : messageParseTestResult.getFailures()){
            i++;
            System.out.println(i +":" + testFailure.toString());
        }

        System.out.println("Test Successful: " + messageParseTestResult.wasSuccessful());

    }
}
