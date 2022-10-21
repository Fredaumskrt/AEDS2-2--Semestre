class booleana {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean extrairBooleano(String expressao, String valor1, String valor2, String resultado) {
        boolean resp = false;

        if (expressao.contains("+")) {
            if (valor1.equals(valor2) && valor1.equals("0")) {
                resp = (resultado.equals("0") ? true : false);
            } else if (valor1.equals(valor2) && valor1.equals("1")) {
                resp = (resultado.equals("1") ? true : false);
            } else {
                resp = (resultado.equals("1") ? true : false);
            }
        } else if (expressao.contains(".")) {
            if (valor1.equals(valor2) && valor1.equals("0")) {
                resp = (resultado.equals("0") ? true : false);
            } else if (valor1.equals(valor2) && valor1.equals("1")) {
                resp = (resultado.equals("1") ? true : false);
            } else {
                resp = (resultado.equals("0") ? true : false);
            }
        }
        return resp;
    }

    public static boolean contemExpressao(String expressao, String valor1, String valor2, String resultado) {
        if (extrairBooleano(expressao, valor1, valor2, resultado)) {
            System.out.println(expressao + " é verdadeiro");
        } else {
            System.out.println(expressao + " é falso");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(entrada[numEntrada]);

        }
    }
}
