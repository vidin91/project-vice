package projectvice.examples.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Example1 {
  public static void main(String[] args) {
    try {
      Class<?> c = Class.forName("projectvice.examples.reflection.SomeClass");
      Method m = c.getMethod("saySomething");
      System.out.println(m.invoke(c.newInstance()));
      
      for(Method m2: c.getMethods()) {
       Class<?> retType = m2.getReturnType();
       if (retType.isArray() && retType.getComponentType() == Integer.class) {
         System.out.println(Arrays.toString((Integer[]) m2.invoke(c.newInstance())));
       }
      }
      
      

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
