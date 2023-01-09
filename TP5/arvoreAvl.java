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
    public classGames elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.
    public int nivel; // Numero de niveis abaixo do no

    public No(classGames elemento) {
        this(elemento, null, null, 1);
    }

    public No(classGames elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }

    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }
}

class AVL {
    private No raiz; // Raiz da arvore.
    public int cmp = 0;

    /**
     * Construtor da classe.
     */
    public AVL() {
        raiz = null;
    }

    public boolean pesquisar(String x) {
        System.out.print("raiz" + " ");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            System.out.print("NAO");
            resp = false;
        } else if (x.compareTo(i.elemento.getname()) == 0) {
            System.out.print("SIM");
            resp = true;
        } else if (x.compareTo(i.elemento.getname()) < 0) {
            cmp++;
            System.out.print("esq ");
            resp = pesquisar(x, i.esq);
        } else {
            cmp++;
            System.out.print("dir ");
            resp = pesquisar(x, i.dir);
        }

        return resp;
    }

    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    private void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + "(fator " + (No.getNivel(i.dir) - No.getNivel(i.esq)) + ") "); // Conteudo do
                                                                                                         // no.
            caminharPre(i.esq); // Elementos da esquerda.
            caminharPre(i.dir); // Elementos da direita.
        }
    }

    public void caminharPos() {
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq); // Elementos da esquerda.
            caminharPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + " "); // Conteudo do no.
        }
    }

    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(classGames x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(classGames x, No i) throws Exception {
        if (i == null) {
            i = new No(x);
        } else if (x.getname().compareTo(i.elemento.getname()) < 0) {

            i.esq = inserir(x, i.esq);
        } else if (x.getname().compareTo(i.elemento.getname()) > 0) {

            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro ao inserir!");
        }

        return balancear(i);
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
    public void remover(String x) throws Exception {
        raiz = remover(x, raiz);
    }

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se nao encontrar elemento.
     */
    private No remover(String x, No i) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao remover!");
        } else if (x.compareTo(i.elemento.getname()) < 0) {
            i.esq = remover(x, i.esq);
        } else if (x.compareTo(i.elemento.getname()) > 0) {

            i.dir = remover(x, i.dir);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return balancear(i);
    }

    private No maiorEsq(No i, No j) {
        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.
            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    private No balancear(No no) throws Exception {
        if (no != null) {
            int fator = No.getNivel(no.dir) - No.getNivel(no.esq);
            // Se balanceada
            if (Math.abs(fator) <= 1) {
                no.setNivel();
                // Se desbalanceada para a direita
            } else if (fator == 2) {
                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

                if (fatorFilhoDir == -1) {
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);

            } else if (fator == -2) {
                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

                if (fatorFilhoEsq == 1) {
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            } else {
                throw new Exception(
                        "Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
            }
        }
        return no;
    }

    private No rotacionarDir(No no) {

        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;
        no.setNivel(); // Atualizar o nivel do no
        noEsq.setNivel(); // Atualizar o nivel do noEsq

        return noEsq;
    }

    private No rotacionarEsq(No no) {

        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel(); // Atualizar o nivel do no
        noDir.setNivel(); // Atualizar o nivel do noDir
        return noDir;
    }
}

class classGames {
    public static final String pastaClasseGames = "/tmp/games.csv";

    private int app_id;
    private String name;
    private Date dateOfYear;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private ArrayList<String> languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private ArrayList<String> genres;

    public classGames() {
        app_id = 0;
        name = "";
        dateOfYear = dateOfYear;
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        languages = new ArrayList<String>();
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0.0f;
        avg_pt = 0;
        developers = "";
        genres = new ArrayList<String>();

    }

    public classGames(int app_id, String name, SimpleDateFormat dateOfYear, String owners, int age, float price,
            int dlcs,
            ArrayList<String> languages, String website, boolean windows, boolean mac, boolean linux, float upvotes,
            int avg_pt, String developers, ArrayList<String> genres) {
        this.app_id = app_id;
        this.name = name;
        this.dateOfYear = new Date();
        this.owners = owners;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;
    }

    public classGames clone() {
        classGames clone = new classGames();

        clone.name = this.name;
        clone.app_id = this.app_id;
        clone.dateOfYear = this.dateOfYear;
        clone.owners = this.owners;
        clone.price = this.price;
        clone.dlcs = this.dlcs;

        clone.languages = new ArrayList<String>();
        clone.languages.addAll(languages);

        clone.website = this.website;
        clone.windows = this.windows;
        clone.mac = this.mac;
        clone.linux = this.linux;
        clone.upvotes = this.upvotes;
        clone.avg_pt = this.avg_pt;
        clone.developers = this.developers;

        clone.genres = new ArrayList<String>();
        clone.genres.addAll(genres);

        return clone;
    }

    public int getapp_id() {
        return app_id;
    }

    public int setapp_id() {
        return app_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Date getdateOfYear() {
        return this.dateOfYear;
    }

    public Date setdateOfYear() {
        return this.dateOfYear;
    }

    public String getowners() {
        return owners;
    }

    public String setowners() {
        return owners;
    }

    public int getage() {
        return age;
    }

    public int setage() {
        return age;
    }

    public float getprice() {
        return this.price;
    }

    public float setprice() {
        return this.price;
    }

    public int getdlcs() {
        return dlcs;
    }

    public int setdlcs() {
        return age;
    }

    public ArrayList<String> getlanguages() {
        return languages;
    }

    public ArrayList<String> setlanguages() {
        return languages;
    }

    public String getwebsite() {
        return website;
    }

    public String setwebsite() {
        return website;
    }

    public boolean getwindows() {
        return windows;
    }

    public boolean setwindows() {
        return windows;
    }

    public boolean getmac() {
        return mac;
    }

    public boolean setmac() {
        return mac;
    }

    public boolean getlinux() {
        return linux;
    }

    public boolean setlinux() {
        return linux;
    }

    public float getupvotes() {
        return this.upvotes;
    }

    public float setupvotes() {
        return this.upvotes;
    }

    public int getavg_pt() {
        return avg_pt;
    }

    public int setavg_pt() {
        return avg_pt;
    }

    public String getdevelopers() {
        return developers;
    }

    public String setdevelopers() {
        return developers;
    }

    public ArrayList<String> getgenres() {
        return genres;
    }

    public ArrayList<String> setgenres() {
        return genres;
    }

    public String removeMarks(String newWords) { // method to remove quotes
        String delete = "";
        for (int i = 0; i < newWords.length(); i++) { // remove where contains quotes on atributes

            if (newWords.charAt(i) == ',') {
                while (newWords.charAt(i) != ',')
                    i++;
            } else {
                delete += newWords.charAt(i);
            }
        }
        return delete;
    }

    private String timeOfstring(int time) {
        if (time == 0)
            return null;

        int hour = time / 60;
        int minute = time - hour * 60;
        String testTime = "";
        if (hour != 0 && minute != 0)
            testTime = Integer.toString(hour) + "h " + Integer.toString(minute) + 'm';

        else if (hour != 0)
            testTime = Integer.toString(hour) + 'h';
        else if (minute != 0)
            testTime += Integer.toString(minute) + 'm';
        else
            testTime = null;
        return testTime;
    }

    public void print() { // show in screen
        String[] array = new String[5];

        String datetoString = "null";
        if (!this.dateOfYear.equals(new Date())) {
            array = this.dateOfYear.toString().split(" ");
            datetoString = array[1] + '/' + array[array.length - 1];
        }

        String price = Float.toString(this.price);
        if (price.charAt(price.length() - 2) == '.' && price.charAt(price.length() - 1) == '0')
            price += '0';
        String website = this.website.length() == 0 ? null : this.website;
        String upvotes = Integer.toString((int) (this.upvotes)) + '%';
        String avg_pt = this.timeOfstring(this.avg_pt);

        System.out.println(this.app_id + " " + this.name + " " + datetoString + " " + this.owners + " " + this.age + " "
                + price + " "
                + this.dlcs + " " + this.languages + " " + website + " " + this.windows + " " + this.mac + " "
                + this.linux + " " + upvotes + " " + avg_pt + " " + this.developers + " " + this.genres);
    }

    public void readapp_id(String games) throws Exception {
        // String folderOfGames = "/tmp/games.csv";
        this.dateOfYear = new Date();
        this.languages.clear();
        this.genres.clear();

        FileReader arq = new FileReader(pastaClasseGames);
        BufferedReader br = new BufferedReader(arq);

        String[] firstLine = new String[20];
        int assistant;
        int assistant02;

        assistant = assistant02 = 0;

        for (int i = 0; i < games.length(); i++) {
            if (games.charAt(i) == '"') {
                assistant = ++i;
                do {
                } while (games.charAt(i++) != '"');
                firstLine[assistant02] = games.substring(assistant, i - 1);
                assistant = i + 1;
                assistant02++;
            } else if (games.charAt(i) == ',') {
                firstLine[assistant02] = games.substring(assistant, i);
                assistant = i + 1;
                assistant02++;
            }
            // pega os genres que não estão delimitados por aspas
            else if ((!(games.charAt(i) == '"')) && (assistant02 == 16)) {
                firstLine[assistant02] = games.substring((games.lastIndexOf(",") + 1), games.length());
                assistant = i + 1;
            }
        }
        // System.out.println(firstLine[0]);
        this.app_id = Integer.parseInt(firstLine[0]);
        this.name = firstLine[1];

        // date doesnt contain day
        try {
            this.dateOfYear = new SimpleDateFormat("MMM dd, yyyy",
                    Locale.ENGLISH).parse(firstLine[2]);
        } catch (ParseException e) {
            // this.dateOfYear = new
            // SimpleDateFormat("MMM/yyyy",Locale.ENGLISH).parse(firstLine[2]);
            this.dateOfYear = new Date();
        }
        this.owners = firstLine[3];
        this.age = Integer.parseInt(firstLine[4]);
        this.price = Float.parseFloat(firstLine[5]);
        this.dlcs = Integer.parseInt(firstLine[6]);

        this.languages.add(firstLine[7].replace("[", "").replace("]", "").replace("'", ""));

        for (int j = 0; j < games.length(); j++) {
            if (languages.contains("[")) {
                this.languages.add(firstLine[7].replace("'", ""));
            } else if (languages.contains("]"))
                ;
        }
        this.website = firstLine[8];
        this.windows = Boolean.parseBoolean(firstLine[9]);
        this.mac = Boolean.parseBoolean(firstLine[10]);
        this.linux = Boolean.parseBoolean(firstLine[11]);
        this.upvotes = Float.parseFloat(firstLine[12])
                / (Float.parseFloat(firstLine[12]) + Float.parseFloat(firstLine[13]));
        this.upvotes = (int) (Math.round(this.upvotes * 100));
        this.avg_pt = Integer.parseInt(firstLine[14]);
        this.developers = firstLine[15];

        try {
            this.genres.add(firstLine[16].replace(",", ", "));
        } catch (NullPointerException e) {
            this.genres.add(firstLine[16]);
        }

    }
}

class arvoreAvl {
    public int app_id;

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        String[] begin = new String[1000]; // entrada
        int count = 0; // contador

        AVL test = new AVL();
        classGames gamesT = new classGames();

        while (true) {
            begin[count] = MyIO.readLine();
            if (begin[count].equals("FIM")) {
                break;
            }
            String gamesContent = findGameByID(classGames.pastaClasseGames, begin[count]);
            gamesT.readapp_id(gamesContent); // busca os atributos
            test.inserir(gamesT.clone());

        }

        int nextEntry;
        nextEntry = MyIO.readInt();

        for (int i = 0; i < nextEntry; i++) {

            begin[count] = MyIO.readLine();
            String action = begin[count].substring(0, 1);
            String receiv = "";

            if (action.compareTo("I") == 0) {
                receiv = begin[count].substring(2);
                // System.out.println(receiv);
                String gamesContent = findGameByID("/tmp/games.csv", receiv);
                gamesT.readapp_id(gamesContent);
                test.inserir(gamesT.clone());
            } else if(action.compareTo("R") == 0){
                receiv = begin[count].substring(2);
                test.remover(receiv);
            }
        }
        String novo[] = new String[1000];
        int quant = 0;
        while (true) {
            novo[quant] = MyIO.readLine();
            if (novo[quant].equals("FIM")) {
                break;
            } else {
                System.out.println(novo[quant]);
                test.pesquisar(novo[quant]);
                System.out.println();
            }
        }

    }

    public static String findGameByID(String gamesFile, String appID) {

        try {
            FileReader arq = new FileReader(gamesFile);
            BufferedReader br = new BufferedReader(arq);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String actualID = line.substring(0, line.indexOf(",")); // lendo primeiro elemento antes da virgula
                if (appID.equals(actualID)) {
                    return line;
                }
            }

            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return "";

    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
}
