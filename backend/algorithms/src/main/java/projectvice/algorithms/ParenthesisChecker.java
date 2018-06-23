package projectvice.algorithms;

import java.util.Stack;

public class ParenthesisChecker {
  static boolean isOpenBracket(char c) {
    return c == '(' || c == '{' || c == '[';
  }
  
  static boolean isCloseBracket(char c) {
    return c == ')' || c == '}' || c == ']';
  }
  
  static char invertBracket(char c) {
    if (isOpenBracket(c) || isCloseBracket(c)) {
      switch (c) {
      case '(': return ')';
      case ')': return '(';
      case '{': return '}';
      case '}': return '{';
      case '[': return ']';
      case ']': return '[';
      }
    }
    return c;
  }
  
  static boolean valid(String input) {
    // Actually, this only compress the same parenthesis together (counter).
    // I could push them all separately - e.g "(((" could do three pushes.
    class Pair {
      int counter;
      char c;
      Pair(int counter, char c) {
        this.counter = counter;
        this.c = c;
      }
    }
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      char current = input.charAt(i);
      if (isOpenBracket(current)) {
        if (!stack.isEmpty()) {
          Pair top = stack.peek();
          if (top.c == current) top.counter++;
          else stack.push(new Pair(1, current));
        } else {
          stack.push(new Pair(1, current));
        }
      }
      
      if (isCloseBracket(current)) {
        if (stack.isEmpty()) return false;
        Pair top = stack.peek();
        if (top.c != invertBracket(current)) return false;
        top.counter--;
        if (top.counter == 0) stack.pop();
      }
    }
    return stack.isEmpty();
  }
  public static void main(String args[]) {
    String input1 = "[()]{}{[()()]()}";
    System.out.println(valid(input1) ? "OK" : "NOT VALID");
  }
}
