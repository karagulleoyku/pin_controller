public class turing {
    private char[] tape; //bant
    private int head; //okunan karakter pozisyonu
    private String state; 
    private char currentDigit;

    public turing(char[] tape) {
        this.tape = tape;
        this.head = 0;          // En soldan başla
        this.state = "q0";      // Başlangıç durumu
    }
    //makineyi başlat
    public void run() {
        System.out.println("Başlangıç Bandı: " + new String(tape));

        while (true) {
            //her adımda durumu yazdır
            System.out.print("[" + state + "] ");
            for (int i = 0; i < tape.length; i++) {
                if (i == head) System.out.print("(" + tape[i] + ")");
                else System.out.print(" " + tape[i] + " ");
            }
            System.out.println();

            switch (state) {
                //kullanııc pininden bir rakam al
                case "q0":
                    if (Character.isDigit(tape[head])) {
                        currentDigit = tape[head];
                        tape[head] = 'X'; //pinde işaretle
                        head++;
                        state = "q1";
                    } else if (tape[head] == '#') {
                        state = "q_accept";
                    } else {
                        state = "q_reject";
                    }
                    break;

                case "q1":
                    while (tape[head] != '#') head++;
                    head++; 
                    state = "q2";
                    break;
                
                // Sabit pinde currentDigit eşleşmesini ara
                case "q2":
                    if (Character.isDigit(tape[head])) {
                        if (tape[head] == currentDigit) {
                            tape[head] = 'Y';
                            head--;
                            state = "q3";
                        } else {
                            state = "q_reject";
                        }
                    } else {
                        head++; 
                    }
                    break;

                // Sabit pinden kullanıcı PIN'ine geri dön
                case "q3":
                    while (tape[head] != '#') head--;
                    head--; 
                    state = "q4";
                    break;

                
                // İşlenmemiş kullanıcı karakteri bul, bir sonraki işleme geç
                case "q4":
                    if (tape[head] == 'X') {
                        head++;
                        state = "q0";
                    } else {
                        head--;
                    }
                    break;

                //başarılı ise
                case "q_accept":
                    System.out.println("[" + state + "] " + new String(tape));
                    System.out.println("Şifre doğru.");
                    return;
                
                //hatalı ise
                case "q_reject":
                    System.out.println("[" + state + "] " + new String(tape));
                    System.out.println("Şifre hatalı.");
                    return;
            }
        }
    }
}
