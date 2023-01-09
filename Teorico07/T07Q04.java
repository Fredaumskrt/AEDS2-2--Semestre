import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

/*
//////////////////////////////////////////////////

Author: Frederico Malaquias A. Caldeira
Matricula: 747544

/////////////////////////////////////////////////
*/
class No {
    public No prox;
    public No contato;

    public No() {

    }

    public No(No elemento) {
        this.contato = contato;
        this.prox = this.prox = null;
    }
}


class Lista {
    private Agenda[] array;
    public int n;
    public int count = 0;
    public int x;

    public Lista(int tamanho) {
        array = new Agenda[tamanho];
        n = 0;
    }

   
    public boolean pesqSequencial(String x) {
        boolean resp = false;
        // int n = x.length;

        for (int i = 0; i < n; i++) {
            
            if (array[i].getName().equals(x)) {
                resp = true;
                i = n;
            }
        }
        return resp;
    }

    public boolean pesqSequencial(int x) {
        boolean resp = false;
        // int n = x.length;

        for (int i = 0; i < n; i++) {
            
            if (array[i].getcpf() == x) {
                resp = true;
                i = n;
            }
        }
        return resp;
    }
 
    public void inserir(Agenda x, int pos) throws Exception {

        // validar insercao
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        n++;
    }

     

    public No remover(int pos) throws Exception {

        // validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        No resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }
    
}

class Agenda {

    private String Name;
    private String Telephone;
    private String Email;
    private int cpf;

    public Agenda() {
        Name = "";
        Telephone = "";
        Email = "";
        cpf = 0;
    }

    public Agenda(String Name, String Telephone, String Email) {
        this.Name = Name;
        this.Telephone = Telephone;
        this.Email = Email;
        this.cpf = cpf;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone() {
        this.Telephone = Telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail() {
        this.Email = Email;
    }

    public int getcpf() {
        return cpf;
    }

    public void setcpf() {
        this.cpf = cpf;
    }

}


