import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int people;
        people = numberOfPeople();
    }
    public static int numberOfPeople() {
        Scanner scanner = new Scanner(System.in);
        int userValue;
        while (true) {
            System.out.println("Введите количество человек.");
            userValue = scanner.nextInt();
            if (userValue == 1) {
                System.out.println("Деление не требуется. Весь счет оплачивает 1 человек.");
                break;
            } else if (userValue <= 0) {
                System.out.println("Введено не корректное значение. Введите количество человек более 1.");
            } else {
                System.out.println("Счет будет разделен на " + userValue);
                break;
            }
        }
        return userValue;
    }
}
