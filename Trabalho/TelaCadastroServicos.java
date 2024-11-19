import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class TelaCadastroServicos extends JFrame {

    private JTextField campoServico;
    private JTextField campoValor;
    private JButton botaoCadastrar;

    @SuppressWarnings("Convert2Lambda")
    public TelaCadastroServicos() {
        setTitle("Cadastro de Serviços");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Definindo o layout principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Cor de fundo azul claro
        getContentPane().setBackground(new Color(173, 216, 230));  // Azul claro

        // Criação dos componentes
        JLabel labelServico = new JLabel("Serviço:");
        campoServico = new JTextField(20);
        campoServico.setPreferredSize(new Dimension(200, 30)); // Tamanho preferencial para o campo
        JLabel labelValor = new JLabel("Valor:");
        campoValor = new JTextField(10);
        campoValor.setPreferredSize(new Dimension(100, 30)); // Tamanho preferencial para o campo
        botaoCadastrar = new JButton("Cadastrar");

        // Organizando os componentes no GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelServico, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(campoServico, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelValor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(campoValor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(botaoCadastrar, gbc);

        // Ação do botão "Cadastrar"
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String servico = campoServico.getText().trim();
                String valor = campoValor.getText().trim();

                // Verificação de campos vazios
                if (servico.isEmpty() || valor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validação do valor inserido como número
                try {
                    Double valorDouble = parseValor(valor);
                    if (valorDouble < 0) {
                        JOptionPane.showMessageDialog(null, "O valor não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Simulação de cadastro de serviço
                    JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos(); // Limpar campos após cadastro
                    dispose(); // Fecha a tela de cadastro
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configuração do botão
        botaoCadastrar.setPreferredSize(new Dimension(150, 40)); // Ajustar o tamanho do botão
        botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoCadastrar.setBackground(new Color(30, 144, 255));  // Cor azul para o botão
        botaoCadastrar.setForeground(Color.WHITE);
        botaoCadastrar.setFocusPainted(false);
        botaoCadastrar.setBorder(BorderFactory.createEmptyBorder());  // Sem borda

        // Configuração da janela
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(true);  // Permite redimensionamento da janela
        setMinimumSize(new Dimension(350, 250));  // Define um tamanho mínimo
        setVisible(true);
    }

    // Método para limpar os campos após o cadastro
    private void limparCampos() {
        campoServico.setText("");
        campoValor.setText("");
    }

    // Método para parsear e formatar o valor inserido
    private Double parseValor(String valor) throws NumberFormatException {
        try {
            // Formatando para garantir que o valor esteja no formato correto
            valor = valor.replace(",", "."); // Substitui vírgula por ponto, caso necessário
            NumberFormat format = NumberFormat.getInstance();
            format.setParseIntegerOnly(false);
            return format.parse(valor).doubleValue();
        } catch (ParseException e) {
            throw new NumberFormatException("Formato inválido");
        }
    }

    public static void main(String[] args) {
        // Criar a interface na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> new TelaCadastroServicos());
    }
}
