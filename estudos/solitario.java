import java.util.Scanner;

public class solitario {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int inteiroN; // valores para preencher o array

        inteiroN = ler.nextInt();
        int array[] = new int[inteiroN]; // array a ser preenchido com a entrada da variavel inteiroN

        for (int i = 0; i < inteiroN; i++) {
            array[i] = ler.nextInt();
            if (array[i + 1] == array[i]) {
                System.out.println(array[i]);
            if(array[i] != array[i + 1])
            System.out.println(array[i]);
            }
        }

        ler.close();
    }
}