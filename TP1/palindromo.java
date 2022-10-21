public class palindromo {
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        
        while(true){
            // enquanto houver alguma entrada, e nao for == ao fim
            if(isFim(entrada)){
                // replace usado para tirar espacos e quebras de linhas    
                entrada = entrada.replaceAll("\\s+", "").toLowerCase().replace("\n", "").replace("\r", ""); // tirar espaço
                break;
            }
            MyIO.println(epalindromo(entrada) ? "SIM": "NAO");
            entrada = MyIO.readLine();
        }
    }

    static boolean epalindromo(String str) {
        for (int i = 0; i < (str.length() / 2) + 1; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false; // ovo
        }
        return true;

    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
}