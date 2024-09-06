import java.util.Scanner;

class Q1 {
    public static void reverseForm(int x) {
        if (x == 0)
            return;
        System.out.print(x % 10);
        reverseForm(x / 10);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        reverseForm(x);
        
        scan.close();
    }
}