
class classGames {

    private String name;
    private String telephone;
    private String email;
    private int cpf;

    public classGames() {
        name = "";
        telephone = "";
        email = "";
        cpf = 0;
    }

    public classGames(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.cpf = cpf;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String gettelephone() {
        return telephone;
    }

    public void settelephone() {
        this.telephone = telephone;
    }

    public String getemail() {
        return email;
    }

    public void setemail() {
        this.email = email;
    }

    public int getcpf() {
        return cpf;
    }

    public void setcpf() {
        this.cpf = cpf;
    }

}
