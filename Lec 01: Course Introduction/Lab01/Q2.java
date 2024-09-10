package Lab01;
import java.util.Scanner;

class Q2 {
    public static String binaryForm(int x) {
        if (x == 0)
            return "";
        return binaryForm(x / 2) + (x % 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if (x == 0)
            System.out.println(0);
        else
            System.out.println(binaryForm(x));
            
        scan.close();
    }
}