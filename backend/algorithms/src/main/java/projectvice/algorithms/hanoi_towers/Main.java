package projectvice.algorithms.hanoi_towers;

public class Main {
  
  public static String getPath(State root, State end) {
    State result = visitState(root, end);
    //return printPath(result);
    return "";
  }
  
  
  
  public static State visitState(State s, State end) {
    if (s.isEqual(end)) {
      return s;
    }
    s.expand();
    for (State next : s.children) {
      State visited = visitState(next, end);
      
      //if (visited != null) return visited;
      if (visited != null) {
        System.out.println(printPath(visited));
      }
    }
    return null;
  }
  
  public static String printPath(State s) {
    String ret = "";
    while (s != null) {
      ret += "(" + s.x + ", " + s.y + ")";
      s = s.parent;
    }
    return ret;
  }
  
  public static void main(String[] args) {
    State root = new State(1, 1);
    State end = new State(3, 3);
    System.out.println(getPath(root, end));
  }
}
