import java.util.Scanner;

public class Telefone {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String tel = ler.nextLine();

        while (tel.equals("FIM") == false) {
            for (int i = 0; i < tel.length(); i++) {
                if (tel.charAt(i) == 'A' || tel.charAt(i) == 'B' || tel.charAt(i) == 'C') {
                    System.out.print("2");
                }
                else if (tel.charAt(i) == 'D' || tel.charAt(i) == 'E' || tel.charAt(i) == 'F') {
                    System.out.print("3");
                }
                else if (tel.charAt(i) == 'G' || tel.charAt(i) == 'H' || tel.charAt(i) == 'I') {
                    System.out.print("4");
                }
                else if (tel.charAt(i) == 'J' || tel.charAt(i) == 'K' || tel.charAt(i) == 'L') {
                    System.out.print("5");
                }
                else if (tel.charAt(i) == 'M' || tel.charAt(i) == 'N' || tel.charAt(i) == 'O') {
                    System.out.print("6");
                }
                else if (tel.charAt(i) == 'P' || tel.charAt(i) == 'Q' || tel.charAt(i) == 'R' || tel.charAt(i) == 'S') {
                    System.out.print("7");
                }
                else if (tel.charAt(i) == 'T' || tel.charAt(i) == 'U' || tel.charAt(i) == 'V') {
                    System.out.print("8");
                }
                else if (tel.charAt(i) == 'W' || tel.charAt(i) == 'X' || tel.charAt(i) == 'Y' || tel.charAt(i) == 'Z') {
                    System.out.print("9");
                }
                else {
                    System.out.print(tel.charAt(i));
                }
                
            }
            System.out.println();
            tel = ler.nextLine();
        }

        System.out.println();
    }
}