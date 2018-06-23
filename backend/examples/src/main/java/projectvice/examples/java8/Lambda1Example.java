package projectvice.examples.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda1Example {
  static class Person {
    String firstName;
    String lastName;
    Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
    public String toString() {
      return String.format("User[%s, %s]", this.firstName, this.lastName);
    }
  }
  
  static interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
  }
  
  public static void main(String[] args) {
    // PersonFactory<Person> factory = (name, lastName) -> new Person(name, lastName);
    PersonFactory<Person> factory = Person::new;
    Person p = factory.create("Milos", "Milenovic");
    System.out.println(p);
  }
}
