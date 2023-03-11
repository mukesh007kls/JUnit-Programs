public class TempConverstion {
    public static final int CELSIUS_To_FAHRENHEIT=1;
    public static final int FAHRENHEIT_To_CELSIUS=2;
    public static void main(String[] args) {
        tempratureConversition(236,1);
    }
    public static void tempratureConversition(double temp,int choice){
        System.out.println("Enter choice:-\n1.Celsius to fahrenheit\n2.Fahrenheit to celsius");
        switch (choice){
            case CELSIUS_To_FAHRENHEIT-> System.out.println((temp*9.0/5)+32);
            case FAHRENHEIT_To_CELSIUS-> System.out.println((temp-32)*5.0/9);
        }
    }
}
