package model;

public class Passagens {
    Destinos destinos = new Destinos();

    //ATRIBUTOS
    private int id_passagem, num_voo;
    private Clientes fk_cliente_id_cliente;
    private Destinos fk_id_destino;
    private float valor;
    private String assento, data_hora;
    

    //MÉTODOS ESPECIAIS
    public Destinos getFk_id_destino() {
        return fk_id_destino;
    }
    public void setFk_id_destino(Destinos fk_id_destino) {
        this.fk_id_destino = fk_id_destino;
    }
    public int getId_passagem() {
        return id_passagem;
    }
    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }
    public Clientes getFk_cliente_id_cliente() {
        return fk_cliente_id_cliente;
    }
    public void setFk_cliente_id_cliente(Clientes fk_cliente_id_cliente) {
        this.fk_cliente_id_cliente = fk_cliente_id_cliente;
    }
    public int getNum_voo() {
        return num_voo;
    }
    public void setNum_voo(int num_voo) {
        this.num_voo = num_voo;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {

        this.valor = valor;
    }
    public String getAssento() {
        return assento;
    }
    public void setAssento(String assento) {
        this.assento = assento;
    }
    public String getData_hora() {
        return data_hora;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public Passagens(){

    }
   
    public Passagens(String assento, String data_hora, int num_voo, Clientes fk_cliente, float valor, Destinos fk_id_destino){
        this.setAssento(assento);
        this.setData_hora(data_hora);
        this.setFk_cliente_id_cliente(fk_cliente);
        this.setNum_voo(num_voo);
        this.setValor(valor);
        this.setFk_id_destino(fk_id_destino);
    }

    private float calcularValorComPromocao(Destinos destino) {
        // Obtém o valor da passagem antes da promoção
        float valorOriginal = getValor();
    
        // Obtém a porcentagem de promoção específica para o destino
        float porcentagemPromocao = destino.getPromocao();
    
        // Calcula o valor com base na promoção (desconto) aplicada
        float valorComPromocao = valorOriginal - (valorOriginal * porcentagemPromocao / 100);
    
        // Certifique-se de que o valor não seja negativo
        if (valorComPromocao < 0) {
            valorComPromocao = 0;
        }
    
        return valorComPromocao;
    }

    public void aplicarPromocao(Destinos destino) {
        float valorComPromocao = calcularValorComPromocao(destino);
        setValor(valorComPromocao);
    }
}
