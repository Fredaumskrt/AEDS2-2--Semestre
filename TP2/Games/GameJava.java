import java.io.*;
//import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

class Game{

    private int app_id;
    private String name;
    private String mes;
    private String ano;
    private String owners;
    private String age;
    private float price;
    private int dlcs;
    private ArrayList<String> languages;
    private ArrayList<String> website;
    private ArrayList<String> windows;
    private Boolean mac;
    private Boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developer;
    private ArrayList<String> genres;

    public Game(){
        app_id = 0;
        name = "";
        setMes("");
        setAno("");
        owners = "";
        age = "";
        price = (float) 0.0;
        dlcs = 0;
        languages = null;
        website = null;
        windows = null;
        mac = false;
        linux = false;
        upvotes = (float) 0.0;
        avg_pt = 0;
        developer = "";
        genres = null;
    }

    

    public Game(int app_id, String name, String mes, String ano, String owners, String age, float price, int dlcs, ArrayList<String> languages, ArrayList<String>website, ArrayList<String> windows, Boolean mac, Boolean linux, float upvotes, int avg_pt, String developer, ArrayList<String> genres){
        this.app_id = app_id;
        this.name = name;
        this.setMes(mes);
        this.setAno(ano);
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developer = developer;
        this.genres = genres;
    }

    public int getApp_id() {
        return app_id;
    }
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
   
    public String getOwners() {
        return owners;
    }
    public void setOwners(String owners) {
        this.owners = owners;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getDlcs() {
        return dlcs;
    }
    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }
    public ArrayList<String> getLanguages() {
        return languages;
    }
    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }
    public ArrayList<String> getWebsite() {
        return website;
    }
    public void setWebsite(ArrayList<String> website) {
        this.website = website;
    }
    public ArrayList<String> getWindows() {
        return windows;
    }
    public void setWindows(ArrayList<String> windows) {
        this.windows = windows;
    }
    public Boolean getMac() {
        return mac;
    }
    public void setMac(Boolean mac) {
        this.mac = mac;
    }
    public Boolean getLinux() {
        return linux;
    }
    public void setLinux(Boolean linux) {
        this.linux = linux;
    }
    public float getUpvotes() {
        return upvotes;
    }
    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }
    public int getAvg_pt() {
        return avg_pt;
    }
    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }
    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public ArrayList<String> getGenres() {
        return genres;
    }
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public Game clone(){
        Game game = new Game();

        game.app_id = this.app_id;
        game.name = this.name;
        game.mes = this.mes;
        game.ano = this.ano;
        game.owners = this.owners;
        game.age = this.age;
        game.price = this.price;
        game.dlcs = this.dlcs;
        game.languages = this.languages;
        game.website = this.website;
        game.windows = this.windows;
        game.linux = this.linux;
        game.upvotes = this.upvotes;
        game.avg_pt = this.avg_pt;
        game.developer = this.developer;
        game.genres = this.genres;

        return game;
    }

    public void imprimir(){
        System.out.println(this.app_id + " " + this.name + " " + this.mes + "/" + this.ano + " "+ this.owners + " " + this.age + " " + this.price + " " + this.dlcs + " " + this.languages + " " + this.website + " " + this.windows + " " + this.linux + " " + this.upvotes + " % " + this.avg_pt + " " + this.developer + " " + this.genres + " " );
    }

    public void ler(String entrada){

        //String file = "/tmp/games.csv";
        String file = "games.csv";
        String aux = "";
        aux = searchString(file, entrada);

        String[] vet = aux.split(",");
        this.app_id = Integer.parseInt(vet[0]);
        this.name = vet[1];
        this.mes = vet[2].substring(1, 4);
        this.ano = vet[3].substring(1, 5);
        this.owners = vet[4];
        this.age = vet[5];
        this.price = Float.parseFloat(vet[6]);
        this.dlcs = Integer.parseInt(vet[7]);
        //----------------------------------------------------------------
        this.languages = new ArrayList<String>();
        int inicio = aux.indexOf("['");
        int fim = aux.indexOf("']");
        String trato = aux.substring(inicio+1, fim);
        this.languages.add(trato);
        //-----------------------------------------------------------------
        this.website = new ArrayList<String>();
        String[] trato2 = aux.split(",");
        String url = "";
        for(String str : trato2) url = str.contains("http") ? str : url;
        this.website.add(url);
        //------------------------------------------------------------------
        this.windows = new ArrayList<String>();
        int inicio3 = aux.indexOf(",");
        int fim3 = aux.indexOf("e");
        String trato3 = aux.substring(inicio3+1, fim3);
        this.website.add(trato3);


        /* 
        this.windows = new ArrayList<String>();
        String[] trato3 = aux.split(",");
        String win = "";
        boolean wind = false;
        for(String str : trato3) win = str.contains("True") ? str : url;
        if(win == "True"){
            wind = true;
        }else{
            wind = false;
        }
        String win1 = Boolean.toString(wind);
       // wind = Boolean.toString(wind);
        this.windows.add(win1);
        */
        //-------------------------------------------------------------------
        

       


        //System.out.println(aux);

    }

    private String removeTags(String line){

        String resp = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') i++;
            }else {
                resp += line.charAt(i);
            }
            i++;
        }
        return resp.replace("&nbsp;", "");
    }



    public String searchString(String file, String busca) {
        String buscaAux = null;
         try {
            FileReader entrada = new FileReader(file); //abrir o arquivo
            BufferedReader br = new BufferedReader(entrada); //leitor do arquivo ate a parte que quero
            buscaAux = br.readLine(); //le a linha e armazena
            while (buscaAux != null) { //quando n for nulo comeca
                if (buscaAux.contains(busca)) { //recebe a variavel busca
                    br.close();
                    return removeTags(buscaAux); // remover as tags
                }
                buscaAux = br.readLine();
            }
            br.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
        return null;
    }
    
}



public class GameJava{

    public static boolean isFim(String entrada) {

        // testar se e'a palavra "FIM"
        return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) throws ParseException {
        Game g = new Game();
        String entrada = "";

        try(Scanner scan = new Scanner(System.in)){

        while(isFim(entrada) ==  false){
            entrada = scan.nextLine();

            if(isFim(entrada) ==  true){
                break;
            }else{
                g = new Game();
                g.ler(entrada);
                g.imprimir();

            }
        }
     }
    }
}