package Aula6;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Aula6_1 extends JFrame{
    // ArrayList para armazenar as tarefas
    private ArrayList<String> listaTarefas;

    // Componentes da interface
    private JTextField campoTarefa;
    private JTextArea areaTextoExibicao;
    private JButton botaoAdicionar;
    private JButton botaoLimpar;

    public Aula6_1(){
        // Inicializa o ArrayList
        listaTarefas=new ArrayList<>();

        // Configurações básicas da janela (JFrame)
        setTitle("Gerenciador de Tarefas");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Define o layout principal como GridLayout (4 linhas, 1 coluna)
        setLayout(new GridLayout(4,1,10,10));

        // --- Linha 1: Painel de Entrada de Dados ---
        JPanel painelEntrada=new JPanel(new GridLayout(1,2,5,5));
        JLabel labelTarefa=new JLabel("Nova Tarefa:",SwingConstants.CENTER);
        campoTarefa=new JTextField();
        painelEntrada.add(labelTarefa);
        painelEntrada.add(campoTarefa);

        // --- Linha 2: Painel de Botões ---
        JPanel painelBotoes=new JPanel(new GridLayout(1,2,5,5));
        botaoAdicionar=new JButton("Adicionar");
        botaoLimpar=new JButton("Limpar Tudo");
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoLimpar);

        // --- Linha 3 e 4: Área de Exibição ---
    }
    
    
}
