public class turing {
    private char[] tape;
    private int head;
    private String state;
    private char currentDigit;

    public turing(char[] tape) {
        this.tape = tape;
        this.head = 0;          // En soldan başla
        this.state = "q0";      // Başlangıç durumu
    }

    public void run() {
        System.out.println("Başlangıç Bandı: " + new String(tape));

        while (true) {
            System.out.print("[" + state + "] ");
            for (int i = 0; i < tape.length; i++) {
                if (i == head) System.out.print("(" + tape[i] + ")");
                else System.out.print(" " + tape[i] + " ");
            }
            System.out.println();

            switch (state) {
                case "q0":
                    if (Character.isDigit(tape[head])) {
                        currentDigit = tape[head];
                        tape[head] = 'X';
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

                case "q3":
                    while (tape[head] != '#') head--;
                    head--; 
                    state = "q4";
                    break;

                case "q4":
                    if (tape[head] == 'X') {
                        head++;
                        state = "q0";
                    } else {
                        head--;
                    }
                    break;

                case "q_accept":
                    System.out.println("[" + state + "] " + new String(tape));
                    System.out.println("Şifre doğru.");
                    return;

                case "q_reject":
                    System.out.println("[" + state + "] " + new String(tape));
                    System.out.println("Şifre hatalı.");
                    return;
            }
        }
    }
}
