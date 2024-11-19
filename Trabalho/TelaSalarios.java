import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TelaSalarios extends JFrame {

    public TelaSalarios() {
        // Definindo o título da janela
        setTitle("Tabela de Salários");

        // Usando GridLayout para organizar os componentes
        setLayout(new GridLayout(9, 3, 10, 10));  // 9 linhas e 3 colunas, com espaçamento entre os componentes

        // Definindo o tamanho da janela
        setSize(500, 400);
        
        // Ação de fechamento da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criando e configurando os títulos das colunas
        JLabel labelCargo = new JLabel("Cargo");
        labelCargo.setFont(new Font("Arial", Font.BOLD, 14));
        labelCargo.setForeground(new Color(0, 0, 128)); // Cor azul para os títulos

        JLabel labelFaixaSalario = new JLabel("Faixa Salarial (R$)");
        labelFaixaSalario.setFont(new Font("Arial", Font.BOLD, 14));
        labelFaixaSalario.setForeground(new Color(0, 0, 128)); // Cor azul para os títulos

        JLabel labelDescricao = new JLabel("Descrição");
        labelDescricao.setFont(new Font("Arial", Font.BOLD, 14));
        labelDescricao.setForeground(new Color(0, 0, 128)); // Cor azul para os títulos

        // Adicionando os títulos ao layout
        add(labelCargo);
        add(labelFaixaSalario);
        add(labelDescricao);

        // Criando os rótulos com as informações de cargos, salários e descrições
        add(new JLabel("Ajudante de Climatização"));
        add(new JLabel("1.200,00 - 1.500,00"));
        add(new JLabel("Executa tarefas básicas de apoio, como transporte de equipamentos e ferramentas."));

        add(new JLabel("Técnico de Manutenção"));
        add(new JLabel("1.800,00 - 2.500,00"));
        add(new JLabel("Responsável pela manutenção e reparo de sistemas de climatização."));

        add(new JLabel("Instalador de Ar Condicionado"));
        add(new JLabel("2.200,00 - 3.000,00"));
        add(new JLabel("Realiza a instalação de sistemas de ar condicionado em clientes residenciais e comerciais."));

        add(new JLabel("Mestre de Obras"));
        add(new JLabel("2.500,00 - 3.500,00"));
        add(new JLabel("Coordena os técnicos na execução das instalações e serviços de climatização."));

        add(new JLabel("Coordenador de Manutenção"));
        add(new JLabel("3.500,00 - 5.000,00"));
        add(new JLabel("Coordena a equipe de manutenção e supervisiona os serviços de climatização."));

        add(new JLabel("Supervisor de Campo"));
        add(new JLabel("4.000,00 - 6.000,00"));
        add(new JLabel("Supervisiona equipes de instalação e manutenção, garante a qualidade dos serviços."));

        add(new JLabel("Gerente de Projetos"));
        add(new JLabel("6.500,00 - 10.000,00"));
        add(new JLabel("Gerencia projetos de climatização, planeja e coordena recursos e prazos."));

        add(new JLabel("Gerente Geral"));
        add(new JLabel("10.000,00 - 15.000,00"));
        add(new JLabel("Responsável pela gestão geral da empresa, estratégias e operações."));

        // Centralizando a janela na tela
        setLocationRelativeTo(null);

        // Tornando a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Criando a interface na thread de eventos do Swing
        SwingUtilities.invokeLater(TelaSalarios::new);
    }
}
