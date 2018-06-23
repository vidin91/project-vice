package projectvice.examples.java8;

import java.util.Objects;

public class Ee {
  public static void main(String[] args) {
    Object o = new Object();
    System.out.println(o.hashCode());
    System.out.println(Objects.hashCode(o));
  }
}
