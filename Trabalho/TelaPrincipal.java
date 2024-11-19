import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaPrincipal extends JFrame {

    // Definição das cores
    private static final Color COR_FUNDO = new Color(214, 236, 247); // Azul claro ou verde água para o fundo
    private static final Color COR_BOTAO = new Color(34, 84, 122);    // Azul forte (cor de confiança e frescor)
    private static final Color COR_TEXTO = new Color(255, 0, 0);      // Cor vermelha para o texto dos botões
    private static final Color COR_TEXTO_HOVER = new Color(255, 0, 0); // Texto vermelho no hover
    private static final Color COR_HOVER = new Color(120, 190, 230);   // Azul claro para hover (sensação de frescor)
    private static final Color COR_CLIQUE = new Color(51, 153, 255);   // Azul vibrante para clique (feedback claro)

    // Construtor da TelaPrincipal
    @SuppressWarnings("unused")
    public TelaPrincipal() {
        setTitle("Tela Principal");

        // Usar GridBagLayout para um layout flexível
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 10, 15, 10); // Espaçamento maior entre os componentes

        // Ação de fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando o painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setBackground(COR_FUNDO); // Cor de fundo alterada para azul claro

        // Criando um título para os botões
        JLabel titulo = new JLabel("Opções de Cadastro e Salários");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20)); // Fonte maior e mais legível
        titulo.setForeground(COR_BOTAO);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas para centralizar o título
        painel.add(titulo, gbc);

        // Criando os botões com suas ações
        JButton botaoCadastroClientes = criarBotao("Cadastro de Clientes", "Gerenciar clientes");
        JButton botaoCadastroFuncionarios = criarBotao("Cadastro de Funcionários", "Gerenciar funcionários");
        JButton botaoCadastroServicos = criarBotao("Cadastro de Serviços", "Gerenciar serviços");
        JButton botaoSalarios = criarBotao("Salários", "Gerenciar salários");

        // Adicionando as ações dos botões
        botaoCadastroClientes.addActionListener(e -> abrirTelaCadastroClientes());
        botaoCadastroFuncionarios.addActionListener(e -> abrirTelaCadastroFuncionarios());
        botaoCadastroServicos.addActionListener(e -> abrirTelaCadastroServicos());
        botaoSalarios.addActionListener(e -> abrirTelaSalarios());

        // Adicionando os botões ao painel com espaçamento vertical
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Resetando para que os botões ocupem uma coluna cada
        painel.add(botaoCadastroClientes, gbc);
        gbc.gridy = 2;
        painel.add(botaoCadastroFuncionarios, gbc);
        gbc.gridy = 3;
        painel.add(botaoCadastroServicos, gbc);
        gbc.gridy = 4;
        painel.add(botaoSalarios, gbc);

        // Adicionando o painel à janela
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Centralizando o painel na janela
        add(painel, gbc);

        // Ajustando o tamanho da janela e tornando-a redimensionável
        setPreferredSize(new Dimension(600, 600)); // Tamanho maior e mais espaçado
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
        setResizable(true); // Permite que o tamanho da janela seja ajustado
        setVisible(true);
    }

    // Método para criar os botões personalizados com nome adicional
    private JButton criarBotao(String texto, String descricao) {
        // Criando o botão com bordas arredondadas e fundo customizado
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // Bordas mais arredondadas para um visual mais suave
            }
        };

        // Definindo a fonte do botão
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Fonte maior e mais visível

        // Ajustando as dimensões automaticamente com base no texto e dando uma margem interna (padding)
        Dimension tamanhoBotao = new Dimension(
            Math.max(300, botao.getPreferredSize().width + 60), // Largura mínima maior para garantir visibilidade
            100 // Aumentando a altura dos botões para uma aparência mais espaçada
        );
        botao.setPreferredSize(tamanhoBotao);

        // Definindo a cor de fundo e o texto do botão
        botao.setBackground(COR_BOTAO);
        botao.setForeground(COR_TEXTO); // Cor vermelha para o texto

        // Removendo o foco padrão do botão para uma aparência limpa
        botao.setFocusPainted(false);

        // Bordas arredondadas e borda adicional para profundidade
        botao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COR_BOTAO, 2),  // Borda sutil de 2px
            BorderFactory.createEmptyBorder(15, 15, 15, 15) // Padding interno
        ));

        botao.setOpaque(true); // Deixa o botão opaco

        // Alinhamento de texto (centro)
        botao.setHorizontalAlignment(SwingConstants.CENTER);
        botao.setVerticalAlignment(SwingConstants.CENTER);

        // Adicionando o nome adicional no botão
        JPanel painelDescricao = new JPanel();
        painelDescricao.setLayout(new GridBagLayout());
        painelDescricao.setOpaque(false);  // Deixa o painel da descrição transparente

        JLabel descricaoLabel = new JLabel(descricao);
        descricaoLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14)); // Ajuste no tamanho da fonte
        descricaoLabel.setForeground(COR_TEXTO); // Texto em vermelho
        GridBagConstraints gbcDescricao = new GridBagConstraints();
        gbcDescricao.gridx = 0;
        gbcDescricao.gridy = 1;
        painelDescricao.add(descricaoLabel, gbcDescricao);

        // Adicionando a descrição ao botão
        botao.add(painelDescricao, BorderLayout.SOUTH);

        // Adicionando o efeito de hover e clique
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBackground(COR_HOVER);  // Alterando a cor de fundo no hover
                botao.setForeground(COR_TEXTO_HOVER); // Texto vermelho no hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBackground(COR_BOTAO);  // Retorna ao fundo original
                botao.setForeground(COR_TEXTO); // Texto vermelho no estado normal
            }

            @Override
            public void mousePressed(MouseEvent e) {
                botao.setBackground(COR_CLIQUE); // Alterando o fundo durante o clique
                botao.setForeground(COR_TEXTO_HOVER); // Texto vermelho no clique
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                botao.setBackground(COR_HOVER); // Retorna ao fundo hover
                botao.setForeground(COR_TEXTO_HOVER); // Texto vermelho no release
            }
        });

        return botao;
    }

    // Métodos para abrir as telas correspondentes
    private void abrirTelaCadastroClientes() {
        new TelaCadastroClientes().setVisible(true);
    }

    private void abrirTelaCadastroFuncionarios() {
        new TelaCadastroFuncionarios().setVisible(true);
    }

    private void abrirTelaCadastroServicos() {
        new TelaCadastroServicos().setVisible(true);
    }

    private void abrirTelaSalarios() {
        new TelaSalarios().setVisible(true);
    }

    public static void main(String[] args) {
        // Criando a interface na thread de eventos do Swing
        SwingUtilities.invokeLater(TelaPrincipal::new);
    }
}
