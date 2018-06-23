package projectvice.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadAndWriteFromProperties {
  public static void initIfNecessary() {
    File out = new File("myconfig.properties");
    FileOutputStream outStream = null;
    if (!out.exists()) {
      Properties p = new Properties();
      p.setProperty("database", "mysql");
      p.setProperty("database_url", "jdbc:mysql://localhost:3306");
      p.setProperty("numberA", "22");
      p.setProperty("numberB", "33");
      try {
        outStream = new FileOutputStream(out);
        p.store(outStream, "");
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (outStream != null) {
          try {
            outStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void main(String[] args) {
    initIfNecessary();
    FileInputStream input;
    try {
      input = new FileInputStream("myconfig.properties");
      Properties props = new Properties();
      props.load(input);
      System.out.println(Integer.parseInt(props.getProperty("numberA")) + Integer.parseInt(props.getProperty("numberB")));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
