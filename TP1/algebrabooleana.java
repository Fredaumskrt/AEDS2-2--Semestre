
public class algebrabooleana{

    public static int primeiro(String s){

        return primeiro(s, 0);
    }

    public static int primeiro(String s, int begin){

        for(int i=begin; i < s.length(); i++){

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){

                return i;
            }
        }

        return 0;
    }

    public static int ultimo(String s){

        int not = s.lastIndexOf("not");
        int and = s.lastIndexOf("and");
        int or = s.lastIndexOf("or");
        
        if(not > and && not > or){//quem é maior

            return not;
        }else if(and > not && and > or){

            return and;
        }else if(or > not && or > and){

            return or;
        }

        return 0;
    }

    public static void main(String[] args) {
        
       while(true){

        int n = MyIO.readInt();//quantidade de letras

        if(n == 0){//condição de finalizar o programa

            break;
        }

        int[] a = new int[n]; //array das letras

        for(int i=0; i < n; i++){//leitura do array

            a[i] = MyIO.readInt();
        }

        String entrada = MyIO.readLine();//expressao completa

        if(entrada.charAt(entrada.length() -1) == ' '){//tratar a entrada removendo os espaços

            entrada = entrada.substring(0, entrada.length() - 1);
        }

        //--------------------------------------------------

        for(int i=0; i < n; i++){//not e elementos sozinhos

            if(i == 0){//A

                entrada = entrada.replace("not(A)", a[0] == 0 ? "1" : "0");//not primeiro pra depois atribuir o valor de a, b, c sozinho
                entrada = entrada.replace("A", a[0] == 0 ? "0" : "1");
            }else if(i == 1){//B

                entrada = entrada.replace("not(B)", a[1] == 0 ? "1" : "0");
                entrada = entrada.replace("B", a[1] == 0 ? "0" : "1");
            }else if(i == 2){//C

                entrada = entrada.replace("not(C)", a[2] == 0 ? "1" : "0");
                entrada = entrada.replace("C", a[2] == 0 ? "0" : "1");
            }
        }

        //--------------------------------------------------

        while(entrada.length() > 1){

            int last = ultimo(entrada);//devinindo a posição da ultima expressao

            String exp = entrada.substring(last, entrada.indexOf(")", last) + 1);//expressao = pagar ate o ultimo )

            if(exp.charAt(0) != 'n'){//diferente de n , ou seja diferente de not

                int count = 1;//contador de virgulas

                for(int i=0; i < exp.length(); i++){//passar por toda a expressao selecionada

                    if(exp.charAt(i) == ','){

                        count++;
                    }
                }

                int[] p = new int[count];//parametros
                int pos = 0;//posição

                for(int i=0; i < count; i++){//ler os parametros e armazenar eles 

                    pos = primeiro(exp, pos);//identificar o primeiro parametro

                    String num = exp.substring(pos, ++pos);//atualizar antes para mandar atualizado no proximo loop

                    p[i] = Integer.parseInt(num);//transformar a string em numero inteiro
                }

                if(exp.charAt(0) == 'a'){//igual a a, ou seja igual a and

                    String resp = "1";//resposta a ser modificada no a, b, c

                    if(count == 1){//analisar se todos sao 1 

                        resp = String.format("%i", p[0]);//colocar um valor inteiro dentro da string
                    }else{

                        for(int i=0; i < count; i++){

                            if(p[i] == 0){//se um for igual a 0 é 0

                                resp = "0";
                                break;
                            }
                        }
                    }

                    entrada = entrada.replace(exp, resp);//modifical no final
                }else if(exp.charAt(0) == 'o'){//igual a o, ou seja igual a or

                    String resp = "0";

                    if(count == 1){

                        resp = String.format("%i", p[0]);
                    }else{

                        for(int i=0; i < count; i++){

                            if(p[i] == 1){

                                resp = "1";
                                break;
                            }
                        }
                    }

                    entrada = entrada.replace(exp, resp);

                }
            }else{//se for not trocar por isso

                if(exp.equals("not(0)")){

                    entrada = entrada.replace("not(0)", "1");
                }else if(exp.equals("not(1)")){

                    entrada = entrada.replace("not(1)", "0");
                }
            }      
        }

        MyIO.println(entrada);
        
       }//fim do while(true)
    }//fim main
}//fim class