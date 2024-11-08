import java.util.Scanner;

public class Sqrt_x {

    public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int low = 1;
        int high = x;
        int mid = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if ((long) mid * mid > x) {
                high = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                low = mid + 1;
            }
        }

        return high; // Integer square root
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its integer square root: ");
        int number = scanner.nextInt();
        System.out.println("The integer square root is: " + sqrt(number));
    }
}
