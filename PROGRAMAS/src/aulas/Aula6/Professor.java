package aulas.Aula6;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    @Override
    public String apresentar() {
        return "Professor: " + getNome()
                + " | Idade: " + getIdade()
                + " | Disciplina: " + disciplina;
    }
}
