public class Funcionario {
    private final String nome;
    private final String cargo;
    private final String email;
    private final String telefone;
    private final String endereco;
    private final String departamento;
    private final String dataNascimento;

    // Construtor para inicializar os atributos
    public Funcionario(String nome, String cargo, String email, String telefone, String endereco, String departamento, String dataNascimento) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
    }

    // Getters para acessar os valores dos atributos
    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    // Opcional: Sobrescrita do método toString para exibir as informações de forma legível
    @Override
    public String toString() {
        return "Funcionario{" +
               "nome='" + nome + '\'' +
               ", cargo='" + cargo + '\'' +
               ", email='" + email + '\'' +
               ", telefone='" + telefone + '\'' +
               ", endereco='" + endereco + '\'' +
               ", departamento='" + departamento + '\'' +
               ", dataNascimento='" + dataNascimento + '\'' +
               '}';
    }
}
