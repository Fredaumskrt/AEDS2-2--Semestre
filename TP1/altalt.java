import java.util.Random;

public class altalt {
    public static boolean isFim(String s) {
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'F' && s.charAt(3) == 'F'){
            return true;
        }
        return false;
    }

    public static String randomString(String s, Random gerador) {
        String test = "";

        
        char x=(char)('a'+(Math.abs(gerador.nextInt())%26)); 
        char z=(char)('a'+(Math.abs(gerador.nextInt())%26));

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == x) {
                test += z;
            }else
            test += s.charAt(i);
        }

        return test;
    }


    public static void main(String[] args) {
        String entrada = "";
        Random gerador= new Random(); //Cria um gerador e a semente indicada (4 neste caso)
        gerador.setSeed(4);
        char w;
        char z;

        entrada = MyIO.readLine();

        while(true){

            if(isFim(entrada) == true) {
                break;
            }
            
            entrada = MyIO.readLine();
        }
        MyIO.println(randomString(entrada[i], gerador));


    }
}
