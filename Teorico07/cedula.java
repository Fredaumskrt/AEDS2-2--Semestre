import java.util.Scanner;

public class cedula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();

        int contador = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(0) != 0) {
                contador++;
            } else if (x.charAt(1) != 0) {
                contador++;
            } else if (x.charAt(2) != 0) {
                contador++;
            }
            int aux = 0;
            if (x.charAt(0) != 0) {
                
                aux = x.charAt(i);
            }
                
            System.out.println(aux + "notas(s) de R$ 100,00");
        }
    }
}
