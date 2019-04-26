import java.util.Scanner;

public class trip {
  private static double total = 0.0;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    int n = Integer.parseInt(stdin.nextLine());
    String tmp;
    for (int i = 0; i < n; i++) {
      tmp = stdin.nextLine();
      solve(tmp);
      System.out.printf("%.2f%n", total);
      total = 0;
    }
  }

  private static void solve(String s) {
    String[] nums = s.split("\\s");
    total += Double.parseDouble(nums[0]) * Double.parseDouble(nums[2]);
    total += Double.parseDouble(nums[1]) * Double.parseDouble(nums[3]);
  }
}
