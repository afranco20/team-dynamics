import java.util.*;

public class polling {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine()), numVotes;
    String s;

    HashMap<String, Integer> map = new HashMap<>(n);

    for (int i = 0; i < n; i++) {
      s = stdin.nextLine();
      if (map.containsKey(s)) {
        numVotes = map.get(s) + 1;
        map.put(s, numVotes);
      } else {
        map.put(s, 1);
      }
    }

    ArrayList<candidate> list = new ArrayList<>(n);
    for (String tmp : map.keySet()) list.add(new candidate(tmp, map.get(tmp)));
    Collections.sort(list);

    Iterator<candidate> itr = list.iterator();
    numVotes = list.get(0).numVotes;
    while (itr.hasNext()) {
      candidate tmp = itr.next();

      if (tmp.numVotes >= numVotes) {
        System.out.println(tmp.print());
      }
    }
  }

  public static class candidate implements Comparable<candidate> {
    String name;
    int numVotes;

    public candidate(String name, int numVotes) {
      this.name = name;
      this.numVotes = numVotes;
    }

    public String print() {
      return name;
    }

    public int compareTo(candidate other) {
      if (this.numVotes != other.numVotes) {
        return Integer.compare(other.numVotes, this.numVotes);
      }

      return this.name.compareTo(other.name);
    }
  }
}
