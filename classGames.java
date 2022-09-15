import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
// import java.text.SimpleDateFormat;
import java.util.ArrayList;

class games {
    private int app_id;
    private String name;
    private SimpleDateFormat dateOfYear = new SimpleDateFormat("dd/mm/yyyy");
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

    public games() {
        app_id = 0;
        name = "";
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        languages = new ArrayList<String>();
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0;
        avg_pt = 0;
        developers = "";
        genres = new ArrayList<String>();

    }

    public games(int app_id, String name, SimpleDateFormat dateOfYear, String owners, int age, float price, int dlcs,
            ArrayList<String> languages, String website, boolean windows, boolean mac, boolean linux, float upvotes,
            int avg_pt, String developers, ArrayList<String> genres) {
        this.app_id = app_id;
        this.name = name;
        this.dateOfYear = dateOfYear;
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

    public String setname() {
        return name;
    }

    // public Date getdateOfYear(){
    // return this.dateOfYear;
    // }

    // public Date setdateOfYear(){
    // return this.dateOfYear;
    // }

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

    // public void readEverything(String games) throws Exception {
    // this.readapp_id(games); // do it for all other atributes !!!!!!!!!!!!
    // }

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

    public void print() { // show in screen

        System.out.println(getapp_id() + " " + getname() + " " + getowners() + " " + getage() + " " + getprice() + " "
                + getdlcs() + "[" + getlanguages() + "]" + getwebsite() + " " + getwindows() + " " + getmac() + " "
                + getlinux() + " " + getupvotes() + " " + getavg_pt() + " " + getdevelopers() + "[" + getgenres()
                + "]");
    }

    // ler a string caractere a caractere com dois contadores
    
    public void readapp_id(String games) throws Exception {
        String folderOfGames = "tmp/games.csv";

        FileReader arq = new FileReader(folderOfGames);
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
        }
        this.app_id = Integer.parseInt(firstLine[0]);
        br.close();
    }

  
}

public class classGames {
    public static void main(String[] args) throws Exception {
        String[] begin = new String[1000]; // entrada
        int count = 0; // numEntrada

        do {
            begin[count] = MyIO.readLine();
        } while (isFim(begin[count++]) == false);
        count--;
        games games[] = new games[count];

        for (int i = 0; i < count; i++) {
            games[i].readapp_id(begin[i]);
        }

        for (int i = 0; i < count; i++) {
            games[i].print();

        }
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
}