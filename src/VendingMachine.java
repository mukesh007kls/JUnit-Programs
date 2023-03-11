
import java.util.Scanner;

public class VendingMachine {
    public static final int[] NOTES = {1000, 500, 100, 50, 10, 5, 2, 1};
    static int i = 0;
    static int totalNumberOfNotes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ammount:-");
        int money = sc.nextInt();
        calculateNotes(money);
        System.out.println("Total number of notes:- " + totalNumberOfNotes);
    }

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
}