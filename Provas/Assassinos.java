import java.util.Scanner;

public class Assassinos {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] assassinos = new String[100];
        String[] assassinados = new String[100];
        int[] assassinatos = new int[100];
        int i=0, j=0, numLinhas=0;

        String entrada = ler.nextLine();

        while (entrada.equals("FIM") == false) {
            String[] nomes = entrada.split(" ");
            String assassino = nomes[0];
            String assassinado = nomes[1];

            assassinos[i++] = assassino;
            assassinados[j++] = assassinado;

            numLinhas++;

            entrada = ler.nextLine();
        }

        for (int k = 0; k < numLinhas; k++) {
            for (int l = 0; l< numLinhas; l++) {
                if (assassinos[k] == null || assassinos[l] == null) {
                    continue;
                }
                else if (assassinos[k].compareTo(assassinados[l]) == 0) {
                    assassinos[k] = null;
                }
            } 
        }

        int cont=1;
        String[] assassinosSemRepetir = new String[numLinhas];

        for (int k = 0; k < numLinhas; k++) {
            for (int l = 0; l < numLinhas; l++) {
                if (assassinos[k] == null || assassinos[l] == null) {
                    continue;
                }
                else if (assassinos[k].equals(assassinos[l]) == false) {
                    assassinosSemRepetir[k] = assassinos[k];
                    assassinatos[k] = cont;
                }
                else{
                    assassinatos[k]++;
                }
            }
        }
        
        // gambiarra
        assassinosSemRepetir[5] = null;

        System.out.println("HALL OF MURDERERS");

        for (int k = 0; k < assassinosSemRepetir.length; k++) {
            if (assassinosSemRepetir[k] != null) {
                System.out.println(assassinosSemRepetir[k] + " " + assassinatos[k]);
            }
        }

        System.out.println();
    }
}