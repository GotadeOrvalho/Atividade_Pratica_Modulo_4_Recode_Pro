package model;

public class Destinos {


    //ATRIBUTOS
    private int id_destino;
    private String cidade, estado, pais, aeroporto;
    private float promocao;

    //MÉTODOS ESPECIAIS
    public float getPromocao() {
        return promocao;
    }
    public void setPromocao(float promocao) {
        this.promocao = promocao;    
    }
    public int getId_destino() {
        return id_destino;
    }
    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getAeroporto() {
        return aeroporto;
    }
    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }

    public Destinos(){

    }

    public Destinos(String cidade, String estado, String pais, String aeroporto, float promocao){
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setPais(pais);
        this.setAeroporto(aeroporto);
        this.setPromocao(promocao);
    }

   
}
