package com.example.algo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GraphTestRunner {

	public static void main(String[] args) {
		// run MatrixTest test methods
		Result result = JUnitCore.runClasses(GraphTest.class);
		System.out.println("Test Summary:");
		System.out.println("Number of tests: " + result.getRunCount());
		System.out.println("Number of failures: " + result.getFailureCount());
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

	}
}
