package Lab01;
import java.util.Scanner;

class T2 {
    public static int gcd(int x, int y) {
        if (y > 0)
            return gcd(y, x % y);
        return x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        System.out.println(gcd(x, y));

        scan.close();
    }
}