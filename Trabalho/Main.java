import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
  private static final List<Cliente> clientes = new ArrayList<>();
  private static final List<Funcionario> funcionarios = new ArrayList<>();
  private static final List<Servico> servicos = new ArrayList<>();
  private static final List<RegistroServico> historicoServicos = new ArrayList<>();
  private static final Scanner scanner = new Scanner(System.in);
  

  public static void main(String[] args) {
    inicializarDadosExemplo();
    exibirMenu();
  }

  private static void exibirMenu() {
    boolean executando = true;
    while (executando) {
      System.out.println("\n--- Menu ---");
      System.out.println("1. Exibir Clientes");
      System.out.println("2. Exibir Funcionários");
      System.out.println("3. Realizar Serviço");
      System.out.println("4. Adicionar Cliente");
      System.out.println("5. Adicionar Funcionário");
      System.out.println("6. Remover Cliente");
      System.out.println("7. Remover Funcionário");
      System.out.println("8. Atualizar Cliente");
      System.out.println("9. Atualizar Funcionário");
      System.out.println("10. Exibir Histórico de Serviços");
      System.out.println("11. Exibir Tabela de Preços");
      System.out.println("12. Sair");

      int opcao = lerEntradaInt("Escolha uma opção: ", 1, 12);
      processarOpcao(opcao);
    }
  }

  private static void processarOpcao(int opcao) {
    switch (opcao) {
      case 1 -> exibirLista("Clientes", clientes);
      case 2 -> exibirLista("Funcionários", funcionarios);
      case 3 -> realizarServico();
      case 4 -> adicionarCliente();
      case 5 -> adicionarFuncionario();
      case 6 -> removerCliente();
      case 7 -> removerFuncionario();
      case 8 -> atualizarCliente();
      case 9 -> atualizarFuncionario();
      case 10 -> exibirHistoricoServicos();
      case 11 -> exibirTabelaDePrecos();
      case 12 -> encerrarSistema();
      default -> System.out.println("Opção inválida! Tente novamente.");
    }
  }

  private static void exibirTabelaDePrecos() {
    System.out.println("\n--- Tabela de Preços de Serviços ---");
    System.out.println("| Serviço                             | Descrição                                              | Preço (R$)  |");
    System.out.println("|-------------------------------------|--------------------------------------------------------|-------------|");
    System.out.println("| Instalação de Ar-Condicionado      | Instalação de unidade de ar-condicionado (split ou janela) | R$ 400,00   |");
    System.out.println("| Manutenção Preventiva              | Limpeza e verificação do sistema de ar-condicionado       | R$ 150,00   |");
    System.out.println("| Manutenção Corretiva               | Reparos em unidades de ar-condicionado                   | R$ 250,00   |");
    System.out.println("| Desinstalação de Ar-Condicionado   | Remoção e desconexão do sistema de ar-condicionado       | R$ 200,00   |");
    System.out.println("| Troca de Filtro de Ar-Condicionado | Substituição de filtro de ar                            | R$ 80,00    |");
    System.out.println("| Limpeza Completa do Sistema        | Limpeza interna e externa de unidades de ar-condicionado | R$ 180,00   |");
    System.out.println("| Instalação de Duto de Ar          | Instalação de dutos para sistemas de ar-condicionado central | R$ 1.000,00 |");
    System.out.println("| Recarregamento de Gás Refrigerante | Recarga de gás R-22 ou R-410A                            | R$ 350,00   |");
    System.out.println("| Diagnóstico de Defeito            | Avaliação e diagnóstico de falhas no sistema             | R$ 120,00   |");
    System.out.println("| Instalação de Ar-Condicionado Portátil | Instalação de modelos portáteis de ar-condicionado   | R$ 250,00   |");
}


  private static int lerEntradaInt(String mensagem, int min, int max) {
    while (true) {
      System.out.print(mensagem);
      String entrada = scanner.nextLine().trim();
      try {
        int valor = Integer.parseInt(entrada);
        if (valor >= min && valor <= max) {
          return valor;
        } else {
          System.out.println("Por favor, insira um número entre " + min + " e " + max + ".");
        }
      } catch (NumberFormatException e) {
        System.out.println("Por favor, insira um número inteiro válido.");
      }
    }
  }

  private static String lerEntradaString(String mensagem) {
    System.out.print(mensagem);
    return scanner.nextLine();
  }

  private static void exibirLista(String titulo, List<?> lista) {
    System.out.println("\n--- " + titulo + " ---");
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(i + ": " + lista.get(i));
    }
  }

  private static void inicializarDadosExemplo() {

  
      
      clientes.add(new Cliente("Ana Silva", "99999-8888", "ana@exemplo.com", "Rua A, 123"));
      clientes.add(new Cliente("Carlos Oliveira", "98888-7777", "carlos@exemplo.com", "Rua B, 456"));
      clientes.add(new Cliente("Maria Souza", "97777-6666", "maria@exemplo.com", "Rua C, 789"));
      clientes.add(new Cliente("João Pereira", "96666-5555", "joao@exemplo.com", "Rua D, 101"));
      clientes.add(new Cliente("Fernanda Lima", "95555-4444", "fernanda@exemplo.com", "Rua E, 202"));
      clientes.add(new Cliente("Lucas Costa", "94444-3333", "lucas@exemplo.com", "Rua F, 303"));
      clientes.add(new Cliente("Patrícia Martins", "93333-2222", "patricia@exemplo.com", "Rua G, 404"));
      clientes.add(new Cliente("Ricardo Gomes", "92222-1111", "ricardo@exemplo.com", "Rua H, 505"));
      clientes.add(new Cliente("Júlia Mendes", "91111-0000", "julia@exemplo.com", "Rua I, 606"));
      clientes.add(new Cliente("Eduardo Rocha", "90000-9999", "eduardo@exemplo.com", "Rua J, 707"));
  
  
      funcionarios.add(new Funcionario("Carlos Souza", "99999-7777", "carlos@exemplo.com"));
      funcionarios.add(new Funcionario("Fernanda Oliveira", "98888-6666", "fernanda@exemplo.com"));
      funcionarios.add(new Funcionario("Rogério Costa", "97777-5555", "rogerio@exemplo.com"));
      funcionarios.add(new Funcionario("Luciana Lima", "96666-4444", "luciana@exemplo.com"));
      funcionarios.add(new Funcionario("Paulo Silva", "95555-3333", "paulo@exemplo.com"));
      funcionarios.add(new Funcionario("Maria José", "94444-2222", "mariajose@exemplo.com"));
      funcionarios.add(new Funcionario("Marcelo Pereira", "93333-1111", "marcelo@exemplo.com"));
      funcionarios.add(new Funcionario("Aline Souza", "92222-0000", "aline@exemplo.com"));
      funcionarios.add(new Funcionario("Jorge Santos", "91111-9999", "jorge@exemplo.com"));
      funcionarios.add(new Funcionario("Cláudia Martins", "90000-8888", "claudia@exemplo.com"));
  
    servicos.add(new Servico("Instalação de ar-condicionado", 600.0));
    servicos.add(new Servico("Manutenção Preventiva", 150.00));
    servicos.add(new Servico("Manutenção Corretiva", 250.00));
    servicos.add(new Servico("Desinstalação de Ar-Condicionado", 200.00));
    servicos.add(new Servico("Troca de Filtro de Ar-Condicionado", 80.00));
    servicos.add(new Servico("Limpeza Completa do Sistema", 180.00));
    servicos.add(new Servico("Instalação de Duto de Ar", 1000.00));
    servicos.add(new Servico("Recarregamento de Gás Refrigerante", 350.00));
    servicos.add(new Servico("Diagnóstico de Defeito", 120.00));
    servicos.add(new Servico("Instalação de Ar-Condicionado Portátil", 250.00));

}

  private static void encerrarSistema() {
    System.out.println("Encerrando o sistema.");
    System.exit(0);
  }

  private static void realizarServico() {
    exibirLista("Clientes", clientes);
    int clienteIndex = lerEntradaInt("Escolha o índice do cliente: ", 0, clientes.size() - 1);

    Cliente cliente = clientes.get(clienteIndex);
    System.out.println("Você escolheu: " + cliente);

    exibirLista("Funcionários", funcionarios);
    int funcionarioIndex = lerEntradaInt("Escolha o índice do funcionário: ", 0, funcionarios.size() - 1);

    Funcionario funcionario = funcionarios.get(funcionarioIndex);
    System.out.println("Você escolheu: " + funcionario);

    exibirLista("Serviços", servicos);
    int servicoIndex = lerEntradaInt("Escolha o índice do serviço: ", 0, servicos.size() - 1);

    Servico servico = servicos.get(servicoIndex);
    System.out.println("Você escolheu: " + servico);

    String dataServico = lerEntradaString("Digite a data do serviço (dd/MM/yyyy): ");

    RegistroServico registro = new RegistroServico(cliente, funcionario, servico, dataServico);
    historicoServicos.add(registro);  // Adicionar o registro ao histórico
    System.out.println("Serviço realizado com sucesso!");
    System.out.println(registro);
  }

  private static void adicionarCliente() {
    System.out.println("Digite os dados do cliente:");
    String nome = lerEntradaString("Nome: ");
    while (nome.isEmpty()) {
        System.out.println("O nome não pode ser vazio.");
        nome = lerEntradaString("Nome: ");
    }

    String telefone = lerEntradaString("Telefone (XX XXXXX-XXXX): ");
    while (!validarTelefone(telefone)) {
        System.out.println("Telefone inválido. O formato deve ser XX XXXXX-XXXX.");
        telefone = lerEntradaString("Telefone (XX XXXXX-XXXX): ");
    }

    String email = lerEntradaString("Email: ");
    while (!validarEmail(email)) {
        System.out.println("Email inválido. Tente novamente.");
        email = lerEntradaString("Email: ");
    }

    String endereco = lerEntradaString("Endereço: ");
    while (endereco.isEmpty()) {
        System.out.println("O endereço não pode ser vazio.");
        endereco = lerEntradaString("Endereço: ");
    }

    // Criando o cliente e adicionando à lista
    Cliente cliente = new Cliente(nome, telefone, email, endereco);
    clientes.add(cliente);
    System.out.println("Cliente adicionado com sucesso!");
}




  private static void adicionarFuncionario() {
    System.out.println("Digite os dados do funcionário:");
    String nome = lerEntradaString("Nome: ");
    while (nome.isEmpty()) {
      System.out.println("O nome não pode ser vazio.");
      nome = lerEntradaString("Nome: ");
    }

    String telefone = lerEntradaString("Telefone (XX XXXXX-XXXX): ");
    while (!validarTelefone(telefone)) {
      System.out.println("Telefone inválido. O formato deve ser XX XXXXX-XXXX.");
      telefone = lerEntradaString("Telefone (XX XXXXX-XXXX): ");
    }

    String email = lerEntradaString("Email: ");
    while (!validarEmail(email)) {
      System.out.println("Email inválido. Tente novamente.");
      email = lerEntradaString("Email: ");
    }

    Funcionario funcionario = new Funcionario(nome, telefone, email);
    funcionarios.add(funcionario);
    System.out.println("Funcionário adicionado com sucesso!");
  }

  private static boolean validarTelefone(String telefone) {
    String regex = "^\\d{2} \\d{5}-\\d{4}$";  // Formato: XX XXXXX-XXXX
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(telefone);
    return matcher.matches();
  }

  private static boolean validarEmail(String email) {
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  private static void removerCliente() {
    exibirLista("Clientes", clientes);
    int clienteIndex = lerEntradaInt("Escolha o índice do cliente a ser removido: ", 0, clientes.size() - 1);
    clientes.remove(clienteIndex);
    System.out.println("Cliente removido com sucesso!");
  }

  private static void removerFuncionario() {
    exibirLista("Funcionários", funcionarios);
    int funcionarioIndex = lerEntradaInt("Escolha o índice do funcionário a ser removido: ", 0, funcionarios.size() - 1);
    funcionarios.remove(funcionarioIndex);
    System.out.println("Funcionário removido com sucesso!");
  }

  private static void atualizarCliente() {
    exibirLista("Clientes", clientes);
    int clienteIndex = lerEntradaInt("Escolha o índice do cliente a ser atualizado: ", 0, clientes.size() - 1);
    Cliente cliente = clientes.get(clienteIndex);
    System.out.println("Atualizando os dados de: " + cliente);

    String nome = lerEntradaString("Novo nome: ");
    String telefone = lerEntradaString("Novo telefone (XX XXXXX-XXXX): ");
    String email = lerEntradaString("Novo email: ");
    String endereco = lerEntradaString("Novo endereço: ");

    cliente.setNome(nome);
    cliente.setTelefone(telefone);
    cliente.setEmail(email);
    cliente.setEndereco(endereco);

    System.out.println("Cliente atualizado com sucesso!");
  }

  private static void atualizarFuncionario() {
    exibirLista("Funcionários", funcionarios);
    int funcionarioIndex = lerEntradaInt("Escolha o índice do funcionário a ser atualizado: ", 0, funcionarios.size() - 1);
    Funcionario funcionario = funcionarios.get(funcionarioIndex);
    System.out.println("Atualizando os dados de: " + funcionario);

    String nome = lerEntradaString("Novo nome: ");
    String telefone = lerEntradaString("Novo telefone (XX XXXXX-XXXX): ");
    String email = lerEntradaString("Novo email: ");

    funcionario.setNome(nome);
    funcionario.setTelefone(telefone);
    funcionario.setEmail(email);

    System.out.println("Funcionário atualizado com sucesso!");
  }

  // Classe RegistroServico
  static class RegistroServico {
    private final Cliente cliente;
    private final  Funcionario funcionario;
    private final  Servico servico;
    private final String dataServico;

    public RegistroServico(Cliente cliente, Funcionario funcionario, Servico servico, String dataServico) {
      this.cliente = cliente;
      this.funcionario = funcionario;
      this.servico = servico;
      this.dataServico = dataServico;
    }

    @Override
    public String toString() {
      return String.format("Registro de Serviço [cliente=%s, funcionário=%s, serviço=%s, data=%s]", 
                           cliente.getNome(), funcionario.getNome(), servico.getDescricao(), dataServico);
    }
  }

  // Classes base Cliente, Funcionario e Servico
  static class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Cliente(String nome, String telefone, String email, String endereco) {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
      this.endereco = endereco;
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

    public String getEndereco() {
      return endereco;
    }

    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }

    @Override
    public String toString() {
      return String.format("Cliente[nome=%s, telefone=%s, email=%s, endereco=%s]", nome, telefone, email, endereco);
    }
  }

  static class Funcionario {
    private String nome;
    private String telefone;
    private String email;

    public Funcionario(String nome, String telefone, String email) {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
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

    @Override
    public String toString() {
      return String.format("Funcionário[nome=%s, telefone=%s, email=%s]", nome, telefone, email);
    }
  }

  static class Servico {
    private final String descricao;
    private final  double preco;

    public Servico(String descricao, double preco) {
      this.descricao = descricao;
      this.preco = preco;
    }

    public String getDescricao() {
      return descricao;
    }

    public double getPreco() {
      return preco;
    }

    @Override
    public String toString() {
      return String.format("Serviço[descricao=%s, preco=%.2f]", descricao, preco);
    }
  }

  private static void exibirHistoricoServicos() {
    System.out.println("\n--- Exibindo Histórico de Serviços ---");
    if (historicoServicos.isEmpty()) {
      System.out.println("Nenhum serviço realizado até o momento.");
    } else {
      for (RegistroServico registro : historicoServicos) {
        System.out.println(registro);
      }
    }
  }
}
