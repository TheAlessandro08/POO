package aulas.Aula5; 

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        try {
            // 1. Cria a instância do Cliente (Isso monta a interface herdada)
            Cliente clienteTela = new Cliente("Carlos Silva",
            "11999999999", 2500.00);

            // 2. Torna a janela do cliente visível na tela
            clienteTela.setVisible(true);

            // 3. Executa um teste de alteração de limite para validar o
            // try-catch visual
            clienteTela.alterarLimiteComTexto("-150.00");
            // Vai disparar aviso visual controlado

        } catch (LimiteInvalidoException e) {
            // Protege o sistema caso o construtor receba dados inválidos
            // logo na inicialização
            JOptionPane.showMessageDialog(null,
                "Erro crítico ao iniciar tela: " + e.getMessage(),
                "Falha na Inicialização",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
