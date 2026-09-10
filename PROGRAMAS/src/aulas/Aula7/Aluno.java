package aulas.Aula7;

public class Aluno extends Pessoa{ //herança

    private double nota; //encapsulamento

    public Aluno(String nome,double nota){ //constructor
        super(nome); //pega da classe pessoa
        this.nota=nota; //pega desta classe
    }

    @Override //polimorfismo
    public String apresentar(){
        return "Aluno: "+getNome()+"\nNota: "+nota;
    }    
}
