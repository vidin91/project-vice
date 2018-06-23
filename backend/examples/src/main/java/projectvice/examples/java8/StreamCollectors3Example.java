/**
 * I have starting group of settings like:
 * [
 *  {name: 'settingA', value: 'value1'},
 *  {name: 'settingB', value: 'settingBValue'},
 *  {name: 'settingA', value: 'another_a_Value'}
 * ]
 * 
 * and I need to group settings with the same name under same key in Map
 */
package projectvice.examples.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StreamCollectors3Example {
  public static void main(String[] args) {
    class Setting {
      String name;
      String value;
      Setting(String name, String value) {this.name = name; this.value = value;}
    }
    
    Object o = Arrays.asList(
      new Setting("width", "100"),
      new Setting("label", "firstLabel"),
      new Setting("label", "secondLabel"),
      new Setting("title", "FANCY TITLE")
    ).stream().reduce(
      new HashMap<String, List<String>>(),
      (acc, setting) -> {
        acc.putIfAbsent(setting.name, new LinkedList<String>());
        acc.get(setting.name).add(setting.value);
        return acc;
      },
      (acc1, acc2) -> acc1 //incorrect but only used in parallel streams 
    );
    System.out.println(o);
  }
}
