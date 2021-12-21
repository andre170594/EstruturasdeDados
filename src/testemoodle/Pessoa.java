package testemoodle;

import java.util.Iterator;

public class Pessoa implements Iterable<String>{

    private final String nome;
    private final String morada;

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public Pessoa(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }


    @Override
    public Iterator<String> iterator() {
        return new IterPessoas(this);
    }
}
