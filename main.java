import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen 4 haneli PIN kodunuzu girin: ");
        String girilenPin = scanner.nextLine();
        if (girilenPin.length() != 4 || !girilenPin.matches("\\d{4}")) {
            System.out.println("PIN kodu 4 basamaklı olmalıdır.");
            return;
        }
        String sabitPin = "1234";
        String input = girilenPin + "#" + sabitPin + "#";
        char[] tape = input.toCharArray();
        turing tm = new turing(tape);
        tm.run();
    }
}
