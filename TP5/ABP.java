import java.util.Scanner;

class main {
    public static class No {
        public int elemento;
        public No esq, dir;

        public No(int elemento) {
            this(elemento, null, null);
        }

        public No(int elemento, No esq, No dir) {
            this.elemento = elemento;
            this.esq = esq;
            this.dir = dir;

        }
    }

    public static class ArvoreBinaria {
        private No raiz;

        public ArvoreBinaria() {
            raiz = null;
        }

        public boolean pesquisar(int x) {
            return pesquisar(x, raiz);
        }

        private boolean pesquisar(int x, No i){
            boolean resp;
            if( i == null){
                resp = false;
            } else if(x == i.elemento){
                resp = true;
            } else if( x < i.elemento){
                resp = pesquisar(x, i.esq);
            } else{
                resp = pesquisar(x, i.dir);
            }
            return resp;
        }
    }
}

public class ABP {
    public static void main(String[] args) {

    }
}
