import java.time.LocalDate;

public class Instalacao {
    private int id;                  
    private String cliente;          
    private String endereco;         
    private String tipoEquipamento;  
    private LocalDate dataInstalacao;
    private double valor;            
    private boolean finalizada;      

    // Construtor
    public Instalacao(int id, String cliente, String endereco, String tipoEquipamento, LocalDate dataInstalacao, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.endereco = endereco;
        this.tipoEquipamento = tipoEquipamento;
        this.dataInstalacao = dataInstalacao;
        this.valor = valor;
        this.finalizada = false; 
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizar() {
        this.finalizada = true;
    }

    // Método para exibir os detalhes da instalação
    @Override
    public String toString() {
        return "Instalação ID: " + id +
                "\nCliente: " + cliente +
                "\nEndereço: " + endereco +
                "\nTipo de Equipamento: " + tipoEquipamento +
                "\nData da Instalação: " + dataInstalacao +
                "\nValor: R$" + valor +
                "\nStatus: " + (finalizada ? "Concluída" : "Pendente");
    }
}
