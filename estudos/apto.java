import java.util.Scanner;


public class apto{

    public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    
    String entrada;  
    String entrada02;
    
    int inteiro, count;
    String test;
    inteiro = sc.nextInt();
   
    for(int i = 0; i < inteiro;i++){
        count = 0;
        entrada = sc.nextLine();
        entrada02 = sc.nextLine();
    
        for(int j = entrada.length(),aux = entrada02.length(); j >= 0; j--, aux--){
            if(entrada[j] == entrada02[aux]){
                count++;
            }
        }

        if(count == entrada.length() + 1){
            System.out.println("encaixa/n");
        }else{
            System.out.println("nao encaixa");
        }
    }
    }
}