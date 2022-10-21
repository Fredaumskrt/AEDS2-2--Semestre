import java.util.Random;

class alteracao {
    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);

        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for(int i = 0; i < numEntrada;i++)
        MyIO.println(alteracao(entrada[i], gerador));

        
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' &&
                s.charAt(2) == 'M');
    }

    public static String alteracao(String entrada, Random gerador){

        String test = "";

        char teste1 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
        char teste2 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
        
        for(int i = 0; i < entrada.length();i++){
            if(entrada.charAt(i) == teste1){
                test += teste2;
            }else
            test += entrada.charAt(i);
        }
        return test;
    }
}
