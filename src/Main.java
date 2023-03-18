import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter choice:-");
        System.out.println("1.Day of week\n2.Temperature check\n3.Monthly payment\n4.Square root\n5.to binary\n6.Vending machine");
        int choice=sc.nextInt();
        switch (choice){
            case 1->readDetails();
            case 2->temperatureConversation();
            case 3->monthlyPayment();
            case 4->sqrt();
            case 5->{
                System.out.println("Enter number");
                int num= sc.nextInt();
                toBinary(num);
            }
            case 6->{
                System.out.println("Enter amount to withdraw:-");
                int money= sc.nextInt();
                calculateNotes(money);
            }
        }
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


    public static final int[] NOTES = {1000, 500, 100, 50, 10, 5, 2, 1};
    static int i = 0;
    static int totalNumberOfNotes = 0;

    public static int calculateNotes(int money) {
        int temp = 0;
        if (money == 0) {
            return -1;
        } else {
            if (money >= NOTES[i]) {

                //numberOfNotes gets how many number of NOTES[i] notes required
                int numberOfNotes = money / NOTES[i];
                //temp gets the money left after selecting the maximum number of notes above
                temp = money % NOTES[i];
                money = temp;
                totalNumberOfNotes += numberOfNotes;
                System.out.println(numberOfNotes + " " + NOTES[i] + " notes are needed");
            }
            i++;
            return calculateNotes(money);
        }
    }


    public static final int CELSIUS_To_FAHRENHEIT = 1;
    public static final int FAHRENHEIT_To_CELSIUS = 2;

    public static void temperatureConversation() {
        System.out.println("Enter choice:-\n1.Celsius to fahrenheit\n2.Fahrenheit to celsius");
        int choice= sc.nextInt();
        System.out.println("Enter temperature:-");
        double temp= sc.nextDouble();
        switch (choice) {
            case CELSIUS_To_FAHRENHEIT -> System.out.println((temp * 9.0 / 5) + 32);
            case FAHRENHEIT_To_CELSIUS -> System.out.println((temp - 32) * 5.0 / 9);
        }
    }

    public static void monthlyPayment() {
        System.out.println("Enter principal amount:-");
        int P = sc.nextInt();
        System.out.println("Enter number of years:-");
        int Y = sc.nextInt();
        System.out.println("Enter interest rate:-");
        float R = sc.nextFloat();
        int n = 12 * Y;
        float r = R / (12 * 100);
        float payment = (float) ((P * r) / (1 - Math.pow(1 + r, -n)));
        System.out.println("Payment:-" + payment);
    }

    public static void sqrt() {
        System.out.println("Enter a non negative number:-");
        int c = sc.nextInt();
        double t = c;
        double epsilon = 1e-15;
        while (Math.abs(t - c / t) > epsilon * t) {
            t = (c / t + t) / 2.0;
        }
        System.out.println("Result:-" + t);
    }

    public static StringBuilder toBinary(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.append(num % 2);
            num = num / 2;
        }
        int i = 2;
        boolean check = false;
        while (!check) {
            if (stringBuilder.length() <= 1) {
                while (stringBuilder.length() < 1) {
                    stringBuilder.append(0);
                }
                check = true;
            }
            i *= 2;
        }
        return stringBuilder.reverse();
    }

}
