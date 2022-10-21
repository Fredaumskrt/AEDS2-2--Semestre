import java.util.Scanner;

public class palindromoRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = new String();

        entrada = sc.nextLine();

        while (true) {

            if (isFim(entrada)) {
                entrada = entrada.toLowerCase();
                entrada = entrada.replaceAll("-", "");
                break;
            }

            System.out.println(epalindromo(entrada, 0) ? "SIM" : "NAO"); 
            entrada = sc.nextLine();
        }
    }


    public static boolean epalindromo(String str, int i) {
        if (i < (str.length() / 2)) { 
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
                return epalindromo(str, ++i);
            } else {
                return false; // ovo
            }
        }
        return true;
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
}
