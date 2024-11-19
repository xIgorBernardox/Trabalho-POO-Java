import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private final JButton botaoLogin;
    private JLabel labelErro;

    @SuppressWarnings("unused")
    public TelaLogin() {
        setTitle("Tela de Login");

        // Usando um painel com rolagem (JScrollPane) para garantir que a interface seja rolável
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(painelPrincipal);

        // Definindo GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Criando componentes
        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField(20);
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);
        botaoLogin = new JButton("Entrar");

        // Label de erro
        labelErro = new JLabel("Usuário ou senha inválidos.");
        labelErro.setForeground(Color.RED);
        labelErro.setVisible(false); // Inicialmente invisível

        // Estilização dos campos e botões
        campoUsuario.setBackground(new Color(240, 240, 240));  // Fundo claro para o campo
        campoUsuario.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        campoSenha.setBackground(new Color(240, 240, 240));
        campoSenha.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        botaoLogin.setBackground(new Color(34, 167, 240));  // Azul de destaque
        botaoLogin.setForeground(Color.WHITE);
        botaoLogin.setFocusPainted(false);
        botaoLogin.setBorder(BorderFactory.createLineBorder(new Color(34, 167, 240), 1));

        Font fonte = new Font("Arial", Font.PLAIN, 14);
        labelUsuario.setFont(fonte);
        labelSenha.setFont(fonte);
        campoUsuario.setFont(fonte);
        campoSenha.setFont(fonte);
        botaoLogin.setFont(fonte);

        // Estilizando o botão com bordas arredondadas
        botaoLogin.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(34, 167, 240), 1),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // Adicionando os componentes ao painel com GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelPrincipal.add(labelUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelPrincipal.add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(labelSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelPrincipal.add(campoSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        painelPrincipal.add(botaoLogin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        painelPrincipal.add(labelErro, gbc);

        // Ação do botão de login
        botaoLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String senha = new String(campoSenha.getPassword()).trim();

            if (usuario.isEmpty() || senha.isEmpty()) {
                labelErro.setText("Por favor, preencha todos os campos.");
                labelErro.setVisible(true);
                return;
            }

            // Simulação de login
            if (usuario.equals("admin123") && senha.equals("1234567")) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();  // Cria a instância da TelaPrincipal
                telaPrincipal.setVisible(true);  // Torna a TelaPrincipal visível
                dispose();  // Fecha a tela de login
            } else {
                labelErro.setText("Usuário ou senha inválidos.");
                labelErro.setVisible(true);
            }
        });

        // Efeito de hover para o botão
        botaoLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                botaoLogin.setBackground(new Color(28, 140, 209)); // Cor mais escura ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                botaoLogin.setBackground(new Color(34, 167, 240)); // Cor original do botão
            }
        });

        // Configurações da janela
        getContentPane().setBackground(new Color(0, 120, 185)); // Cor de fundo azul mais moderno
        setSize(400, 300); // Ajuste no tamanho da janela
        setLocationRelativeTo(null); // Centraliza a tela
        setResizable(true); // Permite redimensionar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando o JScrollPane à janela
        getContentPane().add(scrollPane);

        // Adicionando padding para garantir o espaçamento entre a borda e o conteúdo
        JPanel contentPanel = (JPanel) getContentPane();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Criar a interface na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> new TelaLogin());
    }
}
