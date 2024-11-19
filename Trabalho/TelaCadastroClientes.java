import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaCadastroClientes extends JFrame {

    private final JTextField campoNome;
    private final JTextField campoTelefone;
    private final  JTextField campoEndereco;
    private final JTextField campoEmail;
    private final JButton botaoCadastrar;
    private final JButton botaoCancelar;

    @SuppressWarnings("unused")
    public TelaCadastroClientes() {
        setTitle("Cadastro de Clientes");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Definindo a disposição dos componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Definindo o fundo azul claro
        getContentPane().setBackground(new Color(173, 216, 230)); // Azul claro

        // Inicializando os componentes
        JLabel labelNome = new JLabel("Nome*:");
        campoNome = new JTextField(20);
        campoNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoNome.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoNome.setToolTipText("Digite o nome completo do cliente");

        JLabel labelTelefone = new JLabel("Telefone*:");
        campoTelefone = new JTextField(15);
        campoTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoTelefone.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoTelefone.setToolTipText("Digite o telefone no formato (XX) XXXXX-XXXX");

        JLabel labelEndereco = new JLabel("Endereço*:");
        campoEndereco = new JTextField(30);
        campoEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoEndereco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoEndereco.setToolTipText("Digite o endereço completo");

        JLabel labelEmail = new JLabel("E-mail*:");
        campoEmail = new JTextField(20);
        campoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoEmail.setToolTipText("Digite o e-mail do cliente");

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botaoCadastrar.setBackground(new Color(70, 130, 180));
        botaoCadastrar.setForeground(Color.WHITE);
        botaoCadastrar.setFocusPainted(false);
        botaoCadastrar.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
        botaoCadastrar.setOpaque(true);
        botaoCadastrar.addActionListener(e -> cadastrarCliente());

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botaoCancelar.setBackground(new Color(200, 50, 50));
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setBorder(BorderFactory.createLineBorder(new Color(200, 50, 50)));
        botaoCancelar.setOpaque(true);
        botaoCancelar.addActionListener(e -> dispose()); // Fecha a tela de cadastro

        // Adicionando componentes ao layout com GridBagLayout
        addComponent(gbc, 0, 0, labelNome, campoNome);
        addComponent(gbc, 0, 1, labelTelefone, campoTelefone);
        addComponent(gbc, 0, 2, labelEndereco, campoEndereco);
        addComponent(gbc, 0, 3, labelEmail, campoEmail);

        // Adicionando botões em um painel com layout de fluxo para centralizá-los
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoCancelar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(painelBotoes, gbc);

        // Configuração da janela
        setSize(500, 400); 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponent(GridBagConstraints gbc, int gridx, int gridy, JLabel label, JTextField campo) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        add(label, gbc);

        gbc.gridx = gridx + 1;
        gbc.gridwidth = 1;
        add(campo, gbc);
    }

    private void cadastrarCliente() {
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();
        String email = campoEmail.getText();

        // Validação dos dados
        if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty()) {
            mostrarErro("Por favor, preencha todos os campos obrigatórios.");
        } else if (nome.length() < 3) {
            mostrarErro("Nome deve ter no mínimo 3 caracteres.");
        } else if (!isTelefoneValido(telefone)) {
            mostrarErro("Telefone inválido! Utilize o formato (XX) XXXXX-XXXX.");
        } else if (!isEmailValido(email)) {
            mostrarErro("E-mail inválido! Verifique o formato.");
        } else {
            // Simulação de cadastro
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoTelefone.setText("");
        campoEndereco.setText("");
        campoEmail.setText("");
    }

    private boolean isTelefoneValido(String telefone) {
        // Regex para validar um telefone no formato (XX) XXXXX-XXXX
        Pattern pattern = Pattern.compile("^\\(\\d{2}\\) \\d{5}-\\d{4}$");
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }

    private boolean isEmailValido(String email) {
        // Regex para validar o formato de email
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroClientes());
    }
}
