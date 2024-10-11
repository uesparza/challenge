package com.example.demoSB01.service;

import java.util.*;


class Expression {

    public static int MathChallenge(String str) {
        // code goes here

        return evaluate(str);

    }

    public static int evaluate(String expression) {
        return evaluateTokens(tokenize(expression));
    }

    private static int evaluateTokens(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while (!tokens.isEmpty()) {
            String token = tokens.remove(0);
            if (isNumber(token)) {
                num = Integer.parseInt(token);
            }

            if (token.equals("(")) {
                num = evaluateTokens(tokens);
            }

            if (!isNumber(token) || tokens.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = token.charAt(0);
                num = 0;
                if (token.equals(")")) {
                    break;
                }

            }

        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i <expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    tokens.add(num.toString());
                    num = new StringBuilder();
                }
                if (c != ' ') {
                    tokens.add(String.valueOf(c));
                }
            }
        }

        if (num.length()>0) {
            tokens.add(num.toString());
        }

        return tokens;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String expresion = "6/3-1";
        System.out.println(MathChallenge(expresion));


    }

}