package projectvice.examples.java8;

import java.util.Arrays;
import java.util.List;

public class Streams1Example {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Milos", "aCA", "PetKO", "Stojko", "_22Bot");
    names.stream()
         .filter(name -> {
           System.out.println("Filter: " + name);
           return name.charAt(0) >= 'A' && name.charAt(0) <= 'Z' ||
                  name.charAt(0) >= 'a' && name.charAt(0) <= 'z';
         })
         .sorted((a, b) -> {
           System.out.println("sorted");
           return a.compareTo(b);
         })
         .map(name -> {
           System.out.println("Map: " + name);
           return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
         })
         .forEach(name -> {
           System.out.println("Foreach: " + name);
         });;
    /*
     OUTPUT:
      Filter: Milos
      Filter: aCA
      Filter: PetKO
      Filter: Stojko
      Filter: _22Bot
      sorted
      sorted
      sorted
      sorted
      sorted
      sorted
      Map: Milos
      Foreach: Milos
      Map: PetKO
      Foreach: Petko
      Map: Stojko
      Foreach: Stojko
      Map: aCA
      Foreach: Aca
     */
  }
}
