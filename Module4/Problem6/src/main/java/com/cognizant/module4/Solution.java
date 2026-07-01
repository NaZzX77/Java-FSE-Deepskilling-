package com.cognizant.module4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }
}
