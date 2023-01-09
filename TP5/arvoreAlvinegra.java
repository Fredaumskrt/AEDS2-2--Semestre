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

class NoAN {
    public boolean cor;
    public classGames elemento;
    public NoAN esq, dir;

    public NoAN() {
        // this(-1);
    }

    public NoAN(classGames elemento) {
        this(elemento, false, null, null);
    }

    public NoAN(classGames elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public NoAN(classGames elemento, boolean cor, NoAN esq, NoAN dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Alvinegra {
    private NoAN raiz; // Raiz da arvore.

    /**
     * Construtor da classe.
     */
    public Alvinegra() {
        raiz = null;
    }

    public boolean pesquisar(String elemento) {
        // System.out.print("raiz" + " ");
        // return pesquisar(x, raiz);
        System.out.println(elemento);
        System.out.print("raiz" + " ");
        return pesquisar(elemento, raiz);
    }

    private boolean pesquisar(String elemento, NoAN i) {
        boolean resp;
        if (i == null) {
            System.out.print("NAO\n");
            resp = false;
        } else if (elemento.compareTo(i.elemento.getname()) == 0) {
            System.out.print("SIM\n");
            resp = true;
        } else if (elemento.compareTo(i.elemento.getname()) < 0) {
            // cmp++;
            System.out.print("esq ");
            resp = pesquisar(elemento, i.esq);
        } else {
            // cmp++;
            System.out.print("dir ");
            resp = pesquisar(elemento, i.dir);
        }

        return resp;
    }

    private void inserir(classGames elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
        if (i == null) {
            if (elemento.getname().compareTo(pai.elemento.getname()) < pai.elemento.getname()
                    .compareTo(elemento.getname())) {
                i = pai.esq = new NoAN(elemento, true);
            } else {
                i = pai.dir = new NoAN(elemento, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (elemento.getname().compareTo(i.elemento.getname()) < i.elemento.getname()
                    .compareTo(elemento.getname())) {
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento.getname().compareTo(i.elemento.getname()) > i.elemento
                    .getname().compareTo(elemento.getname())) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }

    }

    public void inserir(classGames elemento) throws Exception {
        // Se a arvore estiver vazia
        if (raiz == null) {
            raiz = new NoAN(elemento);
            // System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento +
            // ").");

            // Senao, se a arvore tiver um elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            if (elemento.getname().compareTo(raiz.elemento.getname()) < raiz.elemento
                    .getname().compareTo(elemento.getname())) {
                raiz.esq = new NoAN(elemento);
                // System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e
                // esq(" + raiz.esq.elemento + ").");
            } else {
                raiz.dir = new NoAN(elemento);
            }

            // Senao, se a arvore tiver dois elementos (raiz e dir)
        } else if (raiz.esq == null) {
            if (elemento.getname().compareTo(raiz.elemento.getname()) < raiz.elemento
                    .getname().compareTo(elemento.getname())) {
                raiz.esq = new NoAN(elemento);
                // System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

            } else if (elemento.getname().compareTo(raiz.elemento.getname()) < raiz.elemento
                    .getname().compareTo(elemento.getname())) {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
                // System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

            } else {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
                // System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, se a arvore tiver dois elementos (raiz e esq)
        } else if (raiz.dir == null) {
            if (elemento.getname().compareTo(raiz.elemento.getname()) > raiz.elemento
                    .getname().compareTo(elemento.getname())) {
                raiz.dir = new NoAN(elemento);
                // System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

            } else if (elemento.getname().compareTo(raiz.elemento.getname()) > raiz.elemento
                    .getname().compareTo(elemento.getname())) {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
                // System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

            } else {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
                // System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento +
                // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, a arvore tem tres ou mais elementos
        } else {
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
        // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if (pai.cor == true) {
            // 4 tipos de reequilibrios e acoplamento
            if (pai.elemento.getname().compareTo(avo.elemento.getname()) > avo.elemento
                    .getname().compareTo(pai.elemento.getname())) { // rotacao a esquerda ou
                                                                                      // direita-esquerda
                if (i.elemento.getname().compareTo(pai.elemento.getname()) > pai.elemento
                        .getname().compareTo(i.elemento.getname())) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else { // rotacao a direita ou esquerda-direita
                if (i.elemento.getname().compareTo(pai.elemento.getname()) < pai.elemento
                        .getname().compareTo(i.elemento.getname())) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento.getname().compareTo(bisavo.elemento.getname()) < bisavo.elemento
                    .getname().compareTo(avo.elemento.getname())) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            // reestabelecer as cores apos a rotacao
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
            // System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e
            // avo.esq / avo.dir("
            // + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
        } // if(pai.cor == true)
    }

    private NoAN rotacaoDir(NoAN no) {
        
        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private NoAN rotacaoEsq(NoAN no) {
        // System.out.println("Rotacao ESQ(" + no.elemento + ")");
        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private NoAN rotacaoDirEsq(NoAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private NoAN rotacaoEsqDir(NoAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public void remover(String receiv) {
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

class arvoreAlvinegra {
    public int app_id;

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        String[] begin = new String[1000]; // entrada
        int count = 0; // contador

        Alvinegra test = new Alvinegra();
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
                // test.remover(receiv);
            }
        }
        String novo[] = new String[1000];
        int quant = 0;
        while (true) {
            novo[quant] = MyIO.readLine();
            if (novo[quant].equals("FIM")) {
                break;
            } else {
                // System.out.println(novo[quant]);
                test.pesquisar(novo[quant]);
                // System.out.println();
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
