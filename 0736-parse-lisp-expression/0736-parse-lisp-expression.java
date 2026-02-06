import java.util.*;

class Solution {
    private Map<String, Deque<Integer>> scope = new HashMap<>();

    public int evaluate(String expression) {
        return eval(expression);
    }

    private int eval(String expr) {
        // If integer
        if (expr.charAt(0) == '-' || Character.isDigit(expr.charAt(0))) {
            return Integer.parseInt(expr);
        }

        // If variable
        if (Character.isLowerCase(expr.charAt(0))) {
            return scope.get(expr).peek();
        }

        // Remove outer parentheses
        String content = expr.substring(1, expr.length() - 1);
        String[] tokens = split(content);

        if (tokens[0].equals("add")) {
            return eval(tokens[1]) + eval(tokens[2]);
        }

        if (tokens[0].equals("mult")) {
            return eval(tokens[1]) * eval(tokens[2]);
        }

        // let expression
        List<String> assigned = new ArrayList<>();

        for (int i = 1; i < tokens.length - 1; i += 2) {
            String var = tokens[i];
            int val = eval(tokens[i + 1]);

            scope.putIfAbsent(var, new ArrayDeque<>());
            scope.get(var).push(val);
            assigned.add(var);
        }

        int result = eval(tokens[tokens.length - 1]);

        // clean scope
        for (String var : assigned) {
            scope.get(var).pop();
        }

        return result;
    }

    // Split expression while respecting parentheses
    private String[] split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder token = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ' && balance == 0) {
                result.add(token.toString());
                token.setLength(0);
            } else {
                if (c == '(') balance++;
                if (c == ')') balance--;
                token.append(c);
            }
        }
        result.add(token.toString());
        return result.toArray(new String[0]);
    }
}
