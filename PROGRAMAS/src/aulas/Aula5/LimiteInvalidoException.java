package aulas.Aula5; 
// É uma regra de erro isolada. Amanhã, ela pode ser usada pela
// classe ContaBancaria ou Venda sem alterar o código do cliente.

public class LimiteInvalidoException extends RuntimeException{ // herança
    public LimiteInvalidoException(String mensagem){
        super(mensagem); // classe pai
    }    
}
