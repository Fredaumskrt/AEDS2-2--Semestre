import java.util.Scanner;

public class Parenteses {
    public static void main(String[] args) {
        String entrada = new String();
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextLine();

        do {
            double contador = 0.0;

            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                if (c == '(') {
                    contador = contador + 1;
                } else if (c == ')') {
                    contador = contador - 1;
                }
                if (c < 0.0) {
                    break;
                }
            }
            if (contador == 0.0) {
                System.out.println("correto");
            } else {
                System.out.println("incorreto");
            }

            entrada = teclado.nextLine();
        } while (!isFim(entrada));

    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' &&
                s.charAt(2) == 'M');
    }
}
