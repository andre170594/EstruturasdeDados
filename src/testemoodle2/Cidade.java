package testemoodle2;

public class Cidade {
    String nome;
    int populacao;

    public Cidade(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    // gets
    public String getNome() { return nome; }
    public int getPopulacao() { return populacao; }

    // sets
    public void setNome(String nome) { this.nome = nome; }
    public void setPopulacao(int populacao) { this.populacao += populacao; }
}
