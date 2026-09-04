package aulas.Aula6;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class SistemaGUI extends JFrame {

    private HashMap<Integer, Pessoa> pessoas;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JComboBox<String> comboTipo;
    private JTextArea areaTexto;

    public SistemaGUI() {
        pessoas = new HashMap<>();

        setTitle("Sistema POO - Java GUI");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        criarInterface();
    }

    private void criarInterface() {
        // NORTH
        JLabel titulo = new JLabel("Sistema de Cadastro - POO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // WEST
        JPanel painelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastro"));

        painelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelFormulario.add(txtId);

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelFormulario.add(txtIdade);

        painelFormulario.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>();
        comboTipo.addItem("Aluno");
        comboTipo.addItem("Professor");
        painelFormulario.add(comboTipo);

        add(painelFormulario, BorderLayout.WEST);

        // CENTER
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        // SOUTH
        JPanel painelBotoes = new JPanel();
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar");
        JButton btnRemover = new JButton("Remover");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRemover);
        add(painelBotoes, BorderLayout.SOUTH);

        // EVENTOS
        btnCadastrar.addActionListener(e -> cadastrar());
        btnListar.addActionListener(e -> listar());
        btnRemover.addActionListener(e -> remover());
    }

    private void cadastrar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String tipo = comboTipo.getSelectedItem().toString();

            Pessoa pessoa;
            if (tipo.equals("Aluno")) {
                pessoa = new Aluno(nome, idade, "Java");
            } else {
                pessoa = new Professor(nome, idade, "Programação");
            }

            pessoas.put(id, pessoa);
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            limpar();

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite números válidos no ID e na idade.");
        }
    }

    private void listar() {
        areaTexto.setText("");

        if (pessoas.isEmpty()) {
            areaTexto.setText("Nenhuma pessoa cadastrada.");
            return;
        }

        for (Integer id : pessoas.keySet()) {
            Pessoa pessoa = pessoas.get(id);
            areaTexto.append(
                    "ID: " + id + "\n"
                    + pessoa.apresentar() + "\n"
                    + "-----------------------------\n"
            );
        }
    }

    private void remover() {
        try {
            int id = Integer.parseInt(txtId.getText());

            if (pessoas.containsKey(id)) {
                pessoas.remove(id);
                JOptionPane.showMessageDialog(this, "Pessoa removida!");
                listar();
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado.");
            }

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite um ID válido.");
        }
    }

    private void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaGUI tela = new SistemaGUI();
            tela.setVisible(true);
        });
    }
}
