package application;

import json.JsonServiceTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args){
        Result testResult = JUnitCore.runClasses(JsonServiceTest.class);
        for (Failure testFailure : testResult.getFailures()){
            System.out.println(testFailure.toString());
        }
        System.out.println(testResult.wasSuccessful());
    }
}
