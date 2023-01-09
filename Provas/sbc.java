import java.util.*;

public class sbc{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int processo = Integer.parseInt(sc.nextLine());

            int espera = 0;
            for(int i = 0; i < processo;i++){
                String caso = sc.nextLine();

                String[] array = caso.split(" ");
                int tempo = Integer.parseInt(array[0]);
                int ciclo = Integer.parseInt(array[1]);

                if((i + 1) != processo)
                espera += ciclo;

                if((i + 1) == processo)
                    System.out.println(espera);
            }
        }
    }
}