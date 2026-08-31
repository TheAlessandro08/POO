package aula5;

import javax.swing.JOptionPane;

public class Cliente extends Pessoa {
    private double limiteCredito;
    
    public Cliente(String nome, String telefone, double limiteCredito) {
        // Envia os dados para o construtor da classe mãe, que cria a tela básica
        super(nome, telefone);
        setTitle("Cadastro de Cliente Comercial"); //Sobrescreve o titulo da janela

        // Aplica a validação da regra de negócio 
        setLimiteCredito(limiteCredito);

        // Configura as ações específicas para os botões herdadas da classe mãe
        configurarAcoesBotoes();
    }

    private void configurarAcoesBotoes() {
        // Ação do botão incluir
        btnIncluir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Preparando formulário para novo cliente",
                "Ação: incluir",
                JOptionPane.INFORMATION_MESSAGE);
        });

        //Ação do Botão Gravar
        btnGravar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Dados salvos com sucesso!\nCliente: " + getNome() + 
                "\nLimite: R$ " + this.limiteCredito, // essas duas linhas são 1
                "Ação: Gravar",
                JOptionPane.INFORMATION_MESSAGE);
        });

        // Ação do Botão Excluir
        btnExcluir.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir o cliente " + getNome() + "?",
                "Confirmação de Exclusão",
                JOptionPane.YES_OPTION);
            
            if (resposta ==  JOptionPane.YES_OPTION) {
                System.out.println("Cliente " + getNome() + " excluído do banco" +
                " simulado.");
            }
        });
    }

    public void setLimiteCredito(double limiteCredito) {
        if (limiteCredito < 0) {
            throw new LimiteInvalidoException("O limite de crédito " +
            "não pode ser negativo! Tentando: R$ " + limiteCredito);
        }
        this.limiteCredito = limiteCredito;
    }

    public void alterarLimiteComTexto(String textoLimite) {
        try {
            double novoLimite  = Double.parseDouble(textoLimite);
            setLimiteCredito(novoLimite);
            JOptionPane.showMessageDialog(this, "Novo limite aplicado: R$ " +
            novoLimite, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Digite apenas " +
                "números válidos!", "Falha na COnversão", JOptionPane.ERROR_MESSAGE);
        } catch (LimiteInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Regra Violada",
            JOptionPane.WARNING_MESSAGE);
        }
    }

    public double getLimiteCredito() {return limiteCredito;}
}
