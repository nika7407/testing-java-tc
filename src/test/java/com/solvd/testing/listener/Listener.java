package com.solvd.testing.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static final Logger log = LogManager.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("test coffee -{}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.warn("test failed -{}", result.getName());
        // sending those warnings somwhere ofc
    }
}