import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class TelaCadastroFuncionarios extends JFrame {

    private final JTextField campoNome;
    private final JTextField campoCargo;
    private final JTextField campoEmail;
    private final JFormattedTextField campoTelefone;
    private final JTextField campoEndereco;
    private final JTextField campoDepartamento;
    private final JTextField campoDataNascimento;
    private final JButton botaoCadastrar;

    private final List<Funcionario> funcionarios;

    public TelaCadastroFuncionarios() {
        
        funcionarios = new ArrayList<>();

        setTitle("Cadastro de Funcionários");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255)); 

        campoNome = criarCampo("Nome*", 20);
        campoCargo = criarCampo("Cargo*", 15);
        campoEmail = criarCampo("Email*", 25);
        campoTelefone = criarCampoTelefone(); 
        campoEndereco = criarCampo("Endereço*", 30);
        campoDepartamento = criarCampo("Departamento*", 20);
        campoDataNascimento = criarCampoDataNascimento(); 

        botaoCadastrar = new JButton("Cadastrar");
        estilizarBotao(botaoCadastrar);

        addComponent("Nome*", campoNome);
        addComponent("Cargo*", campoCargo);
        addComponent("Email*", campoEmail);
        addComponent("Telefone*", campoTelefone);
        addComponent("Endereço*", campoEndereco);
        addComponent("Departamento*", campoDepartamento);
        addComponent("Data de Nascimento*", campoDataNascimento);
        
        JPanel panelBotao = new JPanel();
        panelBotao.setOpaque(false);
        panelBotao.add(botaoCadastrar);
        add(panelBotao);
        
        setSize(450, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        
        campoNome.requestFocus();
    }

    private void addComponent(String labelText, JTextField campo) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setPreferredSize(new Dimension(120, 25));

        panel.add(label);
        panel.add(campo);

        add(panel);
    }

    private JTextField criarCampo(String labelText, int tamanho) {
        JTextField campo = new JTextField(tamanho);
        campo.setToolTipText("Digite o " + labelText.toLowerCase() + " do funcionário.");
        campo.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setMargin(new Insets(5, 5, 5, 5));
        return campo;
    }

    private JFormattedTextField criarCampoTelefone() {
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.setPlaceholderCharacter('_');
            return new JFormattedTextField(telefoneMask);
        } catch (ParseException e) {
            return new JFormattedTextField();
        }
    }

    private JTextField criarCampoDataNascimento() {
        JTextField campo = new JTextField(10);
        campo.setToolTipText("Digite a data de nascimento (dd/MM/yyyy).");
        return campo;
    }

    @SuppressWarnings("unused")
    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(30, 144, 255)); 
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));
        botao.setPreferredSize(new Dimension(150, 40));

        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBackground(new Color(0, 102, 204)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBackground(new Color(30, 144, 255)); 
            }
        });

        botao.addActionListener((ActionEvent e) -> {
            if (validarCampos()) {
                String nome = campoNome.getText().trim();
                String cargo = campoCargo.getText().trim();
                String email = campoEmail.getText().trim();
                String telefone = campoTelefone.getText().trim();
                String endereco = campoEndereco.getText().trim();
                String departamento = campoDepartamento.getText().trim();
                String dataNascimentoTexto = campoDataNascimento.getText().trim();

                Funcionario funcionario = new Funcionario(nome, cargo, email, telefone, endereco, departamento, dataNascimentoTexto);
                funcionarios.add(funcionario);

                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                exibirFuncionarios(); 

                limparCampos(); 
            }
        });
    }

    private void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum funcionário cadastrado ainda.", "Lista de Funcionários", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder listaFuncionarios = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            listaFuncionarios.append("Nome: ").append(funcionario.getNome())
                             .append(", Cargo: ").append(funcionario.getCargo())
                             .append(", Email: ").append(funcionario.getEmail())
                             .append(", Telefone: ").append(funcionario.getTelefone())
                             .append(", Endereço: ").append(funcionario.getEndereco())
                             .append(", Departamento: ").append(funcionario.getDepartamento())
                             .append(", Data de Nascimento: ").append(funcionario.getDataNascimento())
                             .append("\n");
        }

        JOptionPane.showMessageDialog(this, listaFuncionarios.toString(), "Funcionários Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean validarCampos() {
        String nome = campoNome.getText().trim();
        String cargo = campoCargo.getText().trim();
        String email = campoEmail.getText().trim();
        String telefone = campoTelefone.getText().trim();
        String endereco = campoEndereco.getText().trim();
        String departamento = campoDepartamento.getText().trim();
        String dataNascimentoTexto = campoDataNascimento.getText().trim();

        if (nome.isEmpty() || nome.length() < 3 || nome.length() > 50) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório e deve ter entre 3 e 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoNome.requestFocus();
            return false;
        }
        if (cargo.isEmpty() || cargo.length() < 3 || cargo.length() > 50) {
            JOptionPane.showMessageDialog(this, "O campo Cargo é obrigatório e deve ter entre 3 e 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoCargo.requestFocus();
            return false;
        }
        if (email.isEmpty() || !validarEmail(email)) {
            JOptionPane.showMessageDialog(this, "O campo Email é obrigatório e deve ser válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoEmail.requestFocus();
            return false;
        }
        if (telefone.isEmpty() || !telefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "O campo Telefone é obrigatório e deve estar no formato (XX) XXXXX-XXXX.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoTelefone.requestFocus();
            return false;
        }
        if (endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Endereço é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoEndereco.requestFocus();
            return false;
        }
        if (departamento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Departamento é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoDepartamento.requestFocus();
            return false;
        }
        if (dataNascimentoTexto.isEmpty() || !validarDataNascimento(dataNascimentoTexto)) {
            JOptionPane.showMessageDialog(this, "O campo Data de Nascimento é obrigatório e deve estar no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            campoDataNascimento.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    @SuppressWarnings("UseSpecificCatch")
    private boolean validarDataNascimento(String dataNascimento) {
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCargo.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");
        campoEndereco.setText("");
        campoDepartamento.setText("");
        campoDataNascimento.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastroFuncionarios::new);
    }
}

class Funcionario {
    private final String nome;
    private final String cargo;
    private final String email;
    private final String telefone;
    private final String endereco;
    private final String departamento;
    private final String dataNascimento;

    public Funcionario(String nome, String cargo, String email, String telefone, String endereco, String departamento, String dataNascimento) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
    }

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
}
