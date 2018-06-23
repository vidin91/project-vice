package projectvice.examples.java8;

import java.util.Optional;

public class OptionalExample {
  public static String getMessage() {
    //return null;
    return "Hello world";
  }
  public static void main(String[] args) {
    // NOTE - if Optional.of gets null it throws NullPointerException
    Optional<String> value = Optional.ofNullable(getMessage());
    value.ifPresent(System.out::println);
  }
}
