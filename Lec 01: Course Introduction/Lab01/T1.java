package Lab01;
import java.util.Scanner;

class T1 {
    public static int factR(int n) {
        if (n > 1)
            return n * factR(n - 1);
        return 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factR(n));
        
        scan.close();
    }
}