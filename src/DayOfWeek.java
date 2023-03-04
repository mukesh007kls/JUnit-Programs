import java.util.Scanner;

public class DayOfWeek {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        readDetails();
    }

    public static int dayOfWeek(int month, int date, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (date + x + 31 * m / 12) % 7;
    }

    public static void readDetails() {
        System.out.println("Enter Month:-");
        int m = sc.nextInt();
        System.out.println("Enter date:-");
        int d = sc.nextInt();
        System.out.println("Enter Year:-");
        int y = sc.nextInt();
        int dayOfWeek = dayOfWeek(m, d, y);
        System.out.println("Day of the week is:-" + dayOfWeek);
    }
}
