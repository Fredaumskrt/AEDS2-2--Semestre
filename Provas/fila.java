import java.util.Scanner;
import java.util.concurrent.*;
import java.util.StringJoiner;
import java.util.*;

// Os pacientes que chegam na fila do SUS passam por uma triagem imediatamente e vão para a fila
// de atendimento. Na triagem a enfermeira anota o horário de entrada do paciente e quantos minutos
// ele tem até que sua condição de saúde se torne crítica. Sabe-se que os pacientes são atendidos de
// 30 em 30 minutos (sempre nas horas cheias ou meias horas) quando na fila de atendimento. O inicio
// da triagem e do atendimento se dá às 7h da manhã, se não há nenhum paciente sendo atendido e a
// fila está vazia, o primeiro paciente é atendido no instante que chega na triagem. O médico atende até
// o último paciente na fila. A preocupação é se algum paciente atingiu uma condição crítica enquanto
// não tenha sido atendido. Para tanto você foi convidado para verificar na fila quantos pacientes
// atingem a condição crítica.
// Entrada
// A entrada contém vários casos de teste. Cada caso de teste começa com uma linha com o número
// inteiro N, 0 < N < 25;o número de pacientes que chegam à triagem. A seguir são N linhas com os
// valores inteiros H, M e C, com 7 < H < 19, e 0 ≤ M <60, a hora e minuto que o paciente chega
// à triagem. O paciente da linha i sempre chega antes que, e no máximo junto com, o paciente da linha i
// + 1. E 0 ≤C ≤ 720 o número de minutos antes do paciente atingir a condição crítica de saúde.
// Saída
// Para cada caso de teste pede-se que se imprima em uma linha única o número de pacientes que
// atingiram a condição crítica ainda na fila de atendimento.

public class fila{
    public static void main(String[] args){
    // cada valor da variavel entrada, sera um numero N < 60 repetido 3x.
    
    String entrada = "";
    int n = 0;
    
    // entrada = Integer.parseInt(0);
    
    Scanner sc = new Scanner(System.in);
    
    int h = 0; // 7 < H < 19
    int m = 0; // 0 <= m <= 60
    int c = 0; // 0 <= M <= 60
    
    // pacinte linha i sempre antes e no maximo com i + 1
    
    // entrada vai vir, e depois passar valores para serem digitados para o h, seguindo suas respectivas regras
    // fazer a mesma coisa pro m e pro c
    entrada = sc.nextLine();
    
    
    for(int i = 0; i <= 3;i++){
        int vetor[] = new int[n];
        entrada = entrada.replace(" ", "");
        
        h = sc.nextInt();
        
        if(h < 7){
            System.out.print(h);
        }
                       
        else if(h < 19){
            System.out.print(h + "");
        }
        else if(h > 19){
            break;
        }

    }
    entrada = sc.nextLine();
        
    // 0 <= m <= 60
    for(int j = 0; j <= entrada.length();j++){

        int vetorM[] = new int[n];
        // entrada = entrada.replace(" ", "");
        
        m = sc.nextInt();
        
        if(m <= 0){
            System.out.println(m + "");
            continue;
        }
                       
        else if(m <= 60){
            System.out.println(m + "");
            continue;
        }
    }   

    for(int k = 0; k <= entrada.length();k++){
        int vetorc[] = new int[n];
        // entrada = entrada.replace(" ", "");
        
        c = sc.nextInt();
        
        if(c <= 0){
            System.out.print(c + "");
            continue;
        }
                       
        else if(c <= 60){
            System.out.print(c + "");
            continue;
        }
    }   

}
        
}
        



    

 
