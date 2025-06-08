import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan PIN almak
        System.out.print("Lütfen 4 haneli PIN kodunuzu girin: ");
        String girilenPin = scanner.nextLine(); 

        // PIN 4 haneli mi?
        if (girilenPin.length() != 4 || !girilenPin.matches("\\d{4}")) {
            System.out.println("PIN kodu 4 basamaklı olmalıdır."); 
            return;
        }

        // Sabit PIN
        String sabitPin = "1234";

        // Bant gösterimi
        String input = girilenPin + "#" + sabitPin + "#";
        char[] tape = input.toCharArray();

        // Turing 
        turing tm = new turing(tape);
        tm.run();
    }
}
