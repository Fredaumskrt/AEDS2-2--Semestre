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
class Lista {
    private classGames[] array;
    public int n;
    public int count = 0;

    public Lista(int tamanho) {
        array = new classGames[tamanho];
        n = 0;
    }

    public void inserirInicio(classGames x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        n++;
    }

    public void inserirFim(classGames x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x;
        n++;
    }

    public void inserir(classGames x, int pos) throws Exception {

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

    public classGames removerInicio() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        classGames resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public classGames removerFim() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
    }

    public classGames remover(int pos) throws Exception {

        // validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        classGames resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public void swap(int i, int j) {
        classGames temp = this.array[i].clone();
        this.array[i] = this.array[j].clone();
        this.array[j] = temp.clone();
    }

    public void sort() {
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].getdevelopers().compareTo(array[j + 1].getdevelopers()) > array[j + 1].getdevelopers()
                        .compareTo(array[j].getdevelopers())) {
                    swap(j, j + 1);
                    count++;
                }
            }
        }
    }

    public void mostrar() {

        for (int i = 0; i < n; i++) {

            array[i].print();
        }
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
        this.developers = "";
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
            // pega os genres que n??o est??o delimitados por aspas
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

class bolha {
    public int app_id;

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        String[] begin = new String[1000]; // entrada
        int count = 0; // contador

        Lista test = new Lista(1000);
        classGames gamesT = new classGames();

        while (true) {
            begin[count] = MyIO.readLine();
            if (begin[count].equals("FIM")) {
                break;
            }
            String gamesContent = findGameByID(classGames.pastaClasseGames, begin[count]);
            gamesT.readapp_id(gamesContent); // busca os atributos
            test.inserirFim(gamesT.clone());
        }
        test.sort();
        test.mostrar();
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
