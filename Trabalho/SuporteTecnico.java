import java.time.LocalDate;

public class SuporteTecnico {
    private int id;                 
    private String cliente;       
    private String problema;          
    private LocalDate dataSolicitacao; 
    private LocalDate dataConclusao;   
    private String status;             
    private String tecnicoResponsavel; 

    // Construtor
    public SuporteTecnico(int id, String cliente, String problema, LocalDate dataSolicitacao, String tecnicoResponsavel) {
        this.id = id;
        this.cliente = cliente;
        this.problema = problema;
        this.dataSolicitacao = dataSolicitacao;
        this.tecnicoResponsavel = tecnicoResponsavel;
        this.status = "Pendente"; // Status inicial
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

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(String tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    // Método para atualizar o status do suporte técnico
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Método para calcular o tempo estimado para resolução
    public int calcularDiasParaConclusao() {
        if (dataConclusao != null) {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), dataConclusao);
        }
        return -1; // Retorna -1 se a data de conclusão não estiver definida
    }

    // Sobrescrevendo o método toString para exibir informações do suporte técnico
    @Override
    public String toString() {
        return "Suporte Técnico ID: " + id +
               "\nCliente: " + cliente +
               "\nProblema: " + problema +
               "\nData da Solicitação: " + dataSolicitacao +
               "\nData de Conclusão: " + (dataConclusao != null ? dataConclusao : "Não definida") +
               "\nStatus: " + status +
               "\nTécnico Responsável: " + tecnicoResponsavel;
    }
}
