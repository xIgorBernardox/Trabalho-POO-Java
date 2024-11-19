import java.time.LocalDate;

public class Servico {
    private int id;                   
    private String tipo;             
    private String cliente;            
    private String endereco;          
    private LocalDate dataSolicitacao; 
    private LocalDate dataConclusao;   
    private double preco;              
    private String status;           
    private String descricao;          

    // Construtor
    public Servico(int id, String tipo, String cliente, String endereco, LocalDate dataSolicitacao, double preco, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.endereco = endereco;
        this.dataSolicitacao = dataSolicitacao;
        this.preco = preco;
        this.descricao = descricao;
        this.status = "Pendente"; // Status inicial
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método para atualizar o status do serviço
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Método para calcular o tempo estimado até a conclusão
    public int calcularDiasAteConclusao() {
        if (dataConclusao != null) {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), dataConclusao);
        }
        return -1; // Retorna -1 se a data de conclusão não estiver definida
    }

    // Sobrescrevendo o método toString para exibir informações do serviço
    @Override
    public String toString() {
        return "Serviço ID: " + id +
               "\nTipo: " + tipo +
               "\nCliente: " + cliente +
               "\nEndereço: " + endereco +
               "\nData da Solicitação: " + dataSolicitacao +
               "\nData de Conclusão: " + (dataConclusao != null ? dataConclusao : "Não definida") +
               "\nPreço: R$" + preco +
               "\nStatus: " + status +
               "\nDescrição: " + descricao;
    }
}
