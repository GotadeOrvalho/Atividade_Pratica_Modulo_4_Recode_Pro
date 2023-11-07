package model;

public class Clientes {
    //ATRIBUTOS
    private int id_cliente;
    private String nome, telefone, email, data_nascimento, endereco, cpf, senha;

    //MÉTODOS ESPECIAIS
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Clientes(){
        
    }

    public Clientes(
        String nome, String email, String telefone, 
        String data_nascimento, String endereco, String cpf, String senha){

            this.setNome(nome);
            this.setCpf(cpf);
            this.setTelefone(telefone);
            this.setEmail(email);
            this.setData_nascimento(data_nascimento);
            this.setEndereco(endereco);
            this.setSenha(senha);
    }
    
}
