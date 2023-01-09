
import java.util.*;

public class Acampamento {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int quant = Integer.parseInt(ler.nextLine());

        while (quant != 0) {
            ArrayList<String> nomes = new ArrayList<String>();
            ArrayList<Integer> numeros = new ArrayList<Integer>();

            for (int i = 0; i < quant; i++) {
                String entrada = ler.nextLine();
                String[] dados = entrada.split(" ");

                nomes.add(dados[0]);
                numeros.add(Integer.parseInt(dados[1]));
            }

            int soma = 0;

            for (Integer n : numeros) {
                soma += n;
            }

            int media = soma / quant;

            int pos = numeros.indexOf(media);

            System.out.println("Vencedor(a): " + nomes.get(pos));


            quant = Integer.parseInt(ler.nextLine());
        }
    }
}