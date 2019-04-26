import java.util.HashMap;
import java.util.Scanner;

public class treesales {
  static HashMap<String, Employee> company = new HashMap<>();

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    String command, arg_1, arg_2;
    Employee tmp;
    int t, n;

    t = stdin.nextInt();
    for (int i = 1; i <= t; i++) {
      System.out.printf("COMPANY %d%n", i);
      n = stdin.nextInt();

      for (int j = 0; j < n; j++) {
        command = stdin.next();
        switch (command) {
          case "ADD":
            arg_1 = stdin.next();
            arg_2 = stdin.next();
            company.put(arg_2, new Employee(arg_2, arg_1));
            break;
          case "SALE":
            arg_1 = stdin.next();
            arg_2 = stdin.next();

            tmp = company.get(arg_1);
            tmp.setSale(Integer.parseInt(arg_2));
            company.put(arg_1, tmp);

            break;
          case "QUERY":
            arg_1 = stdin.next();
            tmp = company.get(arg_1);
            System.out.println(tmp.sum);
            break;
          default:
            System.out.println("ERROR: invalid command");
            System.exit(-1);
        }
      }
    }
  }

  static class Employee {
    final String name;
    final String parent;
    int sum;
    int sale;

    Employee(String name, String parent) {
      this.name = name;
      this.parent = parent;
      this.sum = 0;
      this.sale = 0;
    }

    void setSale(int sale) {
      this.sum += sale;
      this.sale += sale;

      if (company.containsKey(this.parent)) {
        Employee tmp = company.get(this.parent);
        tmp.setSum(sale);
        company.put(this.parent, tmp);
      }
    }

    void setSum(int sum) {
      this.sum = this.sum + sum;

      if (company.containsKey(this.parent)) {
        Employee tmp = company.get(this.parent);
        tmp.setSum(sum);
        company.put(this.parent, tmp);
      }
    }
  }
}
