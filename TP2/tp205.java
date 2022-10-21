import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Lista {
    private Jogo[] array;
    private int n;
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    public Lista (int tamanho){
       array = new Jogo[tamanho];
       n = 0;
    }
 
 
    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Jogo x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       } 
 
       //levar elementos para o fim do array
       for(int i = n; i > 0; i--){
          array[i] = array[i-1];
       }
 
       array[0] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Jogo x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       }
 
       array[n] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Jogo x, int pos) throws Exception {
 
       //validar insercao
       if(n >= array.length || pos < 0 || pos > n){
          throw new Exception("Erro ao inserir!");
       }
 
       //levar elementos para o fim do array
       for(int i = n; i > pos; i--){
          array[i] = array[i-1];
       }
 
       array[pos] = x;
       n++;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da lista e movimenta 
     * os demais elementos para o inicio da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Jogo removerInicio() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       Jogo resp = array[0];
       n--;
 
       for(int i = 0; i < n; i++){
          array[i] = array[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Jogo removerFim() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       return array[--n];
    }
 
 
    /**
     * Remove um elemento de uma posicao especifica da lista e 
     * movimenta os demais elementos para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Jogo remover(int pos) throws Exception {
 
       //validar remocao
       if (n == 0 || pos < 0 || pos >= n) {
          throw new Exception("Erro ao remover!");
       }
 
       Jogo resp = array[pos];
       n--;
 
       for(int i = pos; i < n; i++){
          array[i] = array[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar (){
       for(int i = 0; i < n; i++){
        System.out.printf("[%d] ", i);
          array[i].imprimir();
       }
    }
 
 }
public class tp205 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> identificadores = new ArrayList<>();
        ArrayList<String> instrucoes = new ArrayList<>();
        int nIntrucoes = 0;
        int contador = 0;

        while(contador < 2) {
            String linha = scanner.nextLine();

            if(contador == 0) {
                if(!isFim(linha)) {
                    identificadores.add(linha);
                }
                else {
                    contador++;
                }
            }
            else {
                if(nIntrucoes == 0) {
                    nIntrucoes = Integer.parseInt(linha);
                }
                else {
                    instrucoes.add(linha);

                    if(instrucoes.size() == nIntrucoes) {
                        contador++;
                    }
                }
            }
        }

        Lista lista = new Lista(100);

        for(int i = 0; i < identificadores.size(); i++) {
            Jogo jogo = new Jogo();

            jogo.ler(identificadores.get(i));
            lista.inserirFim(jogo);
        }

        for(int j = 0; j < instrucoes.size(); j++) {
            if(instrucoes.get(j).contains("II")) {
                String[] dados = instrucoes.get(j).split(" ");
                Jogo jogo = new Jogo();

                jogo.ler(dados[1]);
                lista.inserirInicio(jogo);
            }
            else if(instrucoes.get(j).contains("I*")) {
                String[] dados = instrucoes.get(j).split(" ");
                Jogo jogo = new Jogo();

                jogo.ler(dados[2]);
                lista.inserir(jogo, Integer.parseInt(dados[1]));
            }
            else if(instrucoes.get(j).contains("IF")) {
                String[] dados = instrucoes.get(j).split(" ");
                Jogo jogo = new Jogo();

                jogo.ler(dados[1]);
                lista.inserirFim(jogo);
            }
            else if(instrucoes.get(j).contains("RI")) {
                Jogo jogo = lista.removerInicio();

                System.out.println("(R) "+jogo.getName());
            }
            else if(instrucoes.get(j).contains("R*")) {
                String[] dados = instrucoes.get(j).split(" ");
                Jogo jogo = lista.remover(Integer.parseInt(dados[1]));

                System.out.println("(R) "+jogo.getName());
            }
            else if(instrucoes.get(j).contains("RF")) {
                Jogo jogo = lista.removerFim();

                System.out.println("(R) "+jogo.getName());
            }
        }

        lista.mostrar();
    }

    public static boolean isFim(String s) {
        return s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M';
    }
}


class Jogo {
    private int app_ip;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    public Jogo() {
        app_ip = 0;
        name = "";
        release_date = new Date();
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        languages = new String[0];
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0;
        avg_pt = 0;
        developers = "";
        genres = new String[0];
    }

    public Jogo(int app_ip, String name, Date release_date, String owners, int age, float price, int dlcs, String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres) {
        this.app_ip = app_ip;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
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

    public int getApp_ip() {
        return app_ip;
    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        SimpleDateFormat fmt = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);
        return fmt.format(this.release_date);
    }

    public String getOwners() {
        return owners;
    }

    public int getAge() {
        return age;
    }

    public String getPrice() {
        DecimalFormat dm = new DecimalFormat("0.00");

        return dm.format(this.price).replace(",", ".");
    }

    public int getDlcs() {
        return dlcs;
    }

    public String getLanguages() {
        return Arrays.toString(this.languages);
    }

    public String getWebsite() {
        if (website.isEmpty()) {
            return "null";
        }

        return website;
    }

    public boolean getWindows() {
        return windows;
    }

    public boolean getMac() {
        return mac;
    }

    public boolean getLinux() {
        return linux;
    }

    public String getUpvotes() {
        if (Math.round(this.upvotes) == 0) {
            return "null";
        }

        int resultado = Math.round(this.upvotes);
        return resultado + "%";
    }

    public String getAvg_pt() {
        if (this.avg_pt == 0) {
            return "null";
        } else if (this.avg_pt < 60) {
            int m = this.avg_pt % 60;
            return m + "m";
        } else if (this.avg_pt % 60 == 0) {
            int h = this.avg_pt / 60;
            return h + "h";
        }

        int h = this.avg_pt / 60;
        int m = this.avg_pt % 60;

        return h + "h " + m + "m";
    }

    public String getDevelopers() {
        return developers;
    }

    public String getGenres() {
        return Arrays.toString(this.genres);
    }

    public void setApp_ip(String app_ip) {
        this.app_ip = Integer.parseInt(app_ip);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelease_date(String release_date) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        try {
            this.release_date = fmt.parse(release_date);
        } catch (ParseException e) {
            fmt = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
            this.release_date = fmt.parse(release_date);
        }
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public void setPrice(String price) {
        this.price = Float.parseFloat(price);
    }

    public void setDlcs(String dlcs) {
        this.dlcs = Integer.parseInt(dlcs);
    }

    public void setLanguages(String languages) {
        this.languages = languages.replace(" '", "").replace("'", "").replace("[", "").replace("]", "").split(",");
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setWindows(String windows) {
        this.windows = Boolean.parseBoolean(windows);
    }

    public void setMac(String mac) {
        this.mac = Boolean.parseBoolean(mac);
    }

    public void setLinux(String linux) {
        this.linux = Boolean.parseBoolean(linux);
    }

    public void setUpvotes(String votosPositivos, String votosNegativos) {
        float votosTotais = Float.parseFloat(votosNegativos) + Float.parseFloat(votosPositivos);
        this.upvotes = Float.parseFloat(votosPositivos) * 100 / votosTotais;
    }

    public void setAvg_pt(String avg_pt) {
        this.avg_pt = Integer.parseInt(avg_pt);
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setGenres(String genres) {
        this.genres = genres.split(",");
    }

    public void imprimir() {
        System.out.println(app_ip + " " + name + " " + getRelease_date() + " " + owners + " " + age + " " + getPrice() + " " + dlcs + " " + getLanguages()
                + " " + getWebsite() + " " + windows + " " + mac + " " + linux + " " + getUpvotes() + " " + getAvg_pt() + " " + developers + " " + getGenres());
    }

    public void ler(String identificador) throws ParseException, FileNotFoundException {
        int id = Integer.parseInt(identificador);
        FileReader file = new FileReader("/tmp/games.csv");
        Scanner scanner = new Scanner(file);
        boolean pesquisaAux = true;
        StringBuilder linha = new StringBuilder();

        while (pesquisaAux && scanner.hasNext()) {
            String appID = "";
            int posF = 0;

            linha.setLength(0);
            linha.append(scanner.nextLine());

            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) != ',') {
                    appID += linha.charAt(i);
                } else {
                    posF = i;
                    break;
                }
            }

            if (Integer.parseInt(appID) == id) {
                pesquisaAux = false;
                setApp_ip(appID);
                linha.delete(0, posF);
            }
        }

        String[] atributos = new String[17];

        for (int i = 0; i < 16; i++) {
            StringBuilder atributoAtual = new StringBuilder();
            int contador = 0;

            if (linha.charAt(contador) == ',' && contador + 1 != linha.length() && linha.charAt(contador + 1) == '"') {
                contador += 2;
                while (contador != linha.length() && linha.charAt(contador) != '"') {
                    atributoAtual.append(linha.charAt(contador));
                    contador++;
                }
                linha.delete(0, contador + 1);
            } else if (contador + 1 != linha.length()) {
                contador += 1;
                while (contador != linha.length() && linha.charAt(contador) != ',') {
                    atributoAtual.append(linha.charAt(contador));
                    contador++;
                }
                linha.delete(0, contador);
            }

            atributos[i] = atributoAtual.toString();
        }

        setName(atributos[0]);
        setRelease_date(atributos[1]);
        setOwners(atributos[2]);
        setAge(atributos[3]);
        setPrice(atributos[4]);
        setDlcs(atributos[5]);
        setLanguages(atributos[6]);
        setWebsite(atributos[7]);
        setWindows(atributos[8]);
        setMac(atributos[9]);
        setLinux(atributos[10]);
        setUpvotes(atributos[11], atributos[12]);
        setAvg_pt(atributos[13]);
        setDevelopers(atributos[14]);
        setGenres(atributos[15]);
    }

    @Override
    public Jogo clone() {
        Jogo game = new Jogo();
        game.app_ip = this.app_ip;
        game.name = this.name;
        game.release_date = this.release_date;
        game.owners = this.owners;
        game.age = this.age;
        game.price = this.price;
        game.dlcs = this.dlcs;
        game.languages = this.languages;
        game.website = this.website;
        game.windows = this.windows;
        game.mac = this.mac;
        game.linux = this.linux;
        game.upvotes = this.upvotes;
        game.avg_pt = this.avg_pt;
        game.developers = this.developers;
        game.genres = this.genres;

        return game;
    }
}
