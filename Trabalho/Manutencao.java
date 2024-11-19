import java.time.LocalDate;

public class Manutencao {
    private int id;                   
    private String cliente;          
    private String endereco;        
    private String tipoServico;       
    private LocalDate dataManutencao; 
    private String descricaoProblema; 
    private String status;         
    private double custo;            

    // Construtor
    public Manutencao(int id, String cliente, String endereco, String tipoServico, LocalDate dataManutencao, String descricaoProblema, double custo) {
        this.id = id;
        this.cliente = cliente;
        this.endereco = endereco;
        this.tipoServico = tipoServico;
        this.dataManutencao = dataManutencao;
        this.descricaoProblema = descricaoProblema;
        this.status = "Pendente"; 
        this.custo = custo;
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

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    // Método para atualizar o status da manutenção
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Método para exibir os detalhes da manutenção
    @Override
    public String toString() {
        return "Manutenção ID: " + id +
                "\nCliente: " + cliente +
                "\nEndereço: " + endereco +
                "\nTipo de Serviço: " + tipoServico +
                "\nData da Manutenção: " + dataManutencao +
                "\nDescrição do Problema: " + descricaoProblema +
                "\nStatus: " + status +
                "\nCusto: R$" + custo;
    }
}
