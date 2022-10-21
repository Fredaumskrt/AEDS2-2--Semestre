import java.util.Scanner;

class booleana {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        
        if (n == 0) {
            break;
        }

        int array[] = new int[n];
        String entrada = new String();

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        entrada = MyIO.readLine();


        int numEntrada;

    }
}
        
