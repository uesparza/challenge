package com.example.demoSB01.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceExp {

    public int getExpression(String expression) {
        return Expression.MathChallenge(expression);
    }

    public int getConsecutive(int[] arr) {
        return GreaterConsecutive.consecutive(arr);
    }
}
