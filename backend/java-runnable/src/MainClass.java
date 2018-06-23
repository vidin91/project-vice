
public class MainClass {
  public static void main(String[] args) {
    try {
      Class.forName("TestClass");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
