import java.util.Scanner;

public class fluxo {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String entrada = ler.nextLine();

        int quant = Character.getNumericValue(entrada.charAt(0));
        int casos = Character.getNumericValue(entrada.charAt(2));

        int[] trem = new int[quant+1];

        for (int i = 0; i < casos; i++) {
            String fluxo = ler.nextLine();
            fluxo = fluxo.replace(" ", "");

            if (fluxo.charAt(0) == '1') {
                int vagao = Character.getNumericValue(fluxo.charAt(1));
                int pessoas = Character.getNumericValue(fluxo.charAt(2));

                trem[vagao] += pessoas;

            }
            else if (fluxo.charAt(0) == '2') {
                int limite1 = Character.getNumericValue(fluxo.charAt(1));
                int limite2 = Character.getNumericValue(fluxo.charAt(2));
                int limite3 = Character.getNumericValue(fluxo.charAt(3));
                int limite4 = Character.getNumericValue(fluxo.charAt(4));

                int soma = 0;
                if(limite3 <= limite1 && limite4 >= limite2){
                    for (int j = limite3; j <= limite4; j++) {
                        soma += trem[j];
                    }
                }
                else if(limite2 == limite3){
                    for (int j = limite1; j <= limite4; j++) {
                        soma += trem[j];
                    }
                }
                else if(limite1 == limite2){
                    soma += trem[limite1];
                }
                else if(limite3 == limite4){
                    soma += trem[limite3];
                }
                else{
                    for (int j = limite1; j <= limite2; j++) {
                        soma += trem[j];
                    }
                    for (int j = limite3; j <= limite4; j++) {
                        soma += trem[j];
                    }
                }
                System.out.println(soma);
            }
            
        }
    }
}
