import java.util.Scanner;

// declarar valor de inteiros valendo 5
// scanner recebe os valores do usuario
public class exercicio01 {

    public static void main(String[] args) {

        int[] inteiros = new int[5];
        int x = 0;
        Scanner entrada = new Scanner(System.in);
        // + (i+1) +
        // recebendo array de 5 inteiros
        for (int i = 0; i < 5; i++) {
            System.out.print("\nDigite os valores desejados" + (i + 1) + ": ");
            inteiros[i] = entrada.nextInt();
        }
        // recebendo apenas 1 numero inteiro
        System.out.printf("\nEntre com um numero inteiro\n", x);
        x = entrada.nextInt();
        boolean result = xInArray(inteiros, x); // resultado da function inteiros
        if (result == true) {
            System.out.println("\nO valor " + x + " foi encontrado: ");
        } else {
            System.out.println("\no valor " + x + " nao foi encontrado: ");
        }
        entrada.close();
    }

    public static boolean xInArray(int[] array, int x) {
        boolean result = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                result = true;
                i = array.length;
                
            }
        }
        return result;
    }

}
