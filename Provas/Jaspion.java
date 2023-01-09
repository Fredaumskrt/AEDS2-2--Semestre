

import java.util.*;

public class Jaspion{

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int casos = Integer.parseInt(ler.nextLine());

        for (int i = 0; i < casos; i++) {
            ArrayList<String> japones = new ArrayList<String>();
            ArrayList<String> portugues = new ArrayList<String>();
            
            String info = ler.nextLine();
            String[] dados = info.split(" ");
            
            int dicionario = Integer.parseInt(dados[0]);
            int frases = Integer.parseInt(dados[1]);

            for (int j = 0; j < dicionario; j++) {
                japones.add(ler.nextLine());
                portugues.add(ler.nextLine());
            }

            for (int j = 0; j < frases; j++) {
                String traduzir = ler.nextLine();
                String[] palavras = traduzir.split(" ");
                String novo = "";

                
                for (String s : palavras) {
                    boolean resp; 
                    resp = japones.contains(s);

                    for (int k = 0; k < dicionario; k++) {
                        
                        if(s.compareTo(japones.get(k)) == 0){
                            novo += portugues.get(k) + " ";
                        }
                        
                        else if(resp == false){
                            novo += s + " ";
                            k = dicionario;
                        }
                    }
                }

                System.out.println(novo);
                
            }

            System.out.println();
        }

    }

}