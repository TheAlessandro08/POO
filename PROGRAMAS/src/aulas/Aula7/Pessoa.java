package aulas.Aula7;

public abstract class Pessoa { //classe abstrata

    private String nome; //encapsulamento

    public Pessoa(String nome){ //constructor
        this.nome=nome;
    }

    public void setNome(String nome){ //setter
        this.nome=nome;
    }

    public String getNome(){
        return nome;
    }

    public abstract String apresentar(); //método abstrato
    
}
