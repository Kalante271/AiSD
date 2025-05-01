package Task1;

import java.util.Stack;

public class Task1 {
    public static boolean isBracketsCorrect(String text) {
        Stack<Character> container = new Stack<>();

        for (char symbol : text.toCharArray()) {
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                container.push(symbol);
            } else {
                if (container.isEmpty()) return false;
                char last = container.pop();
                if (!((symbol == ')' && last == '(') || (symbol == '}' && last == '{') || (symbol == ']' && last == '['))) return false;
            }
        }

        return container.isEmpty();
    }
}
