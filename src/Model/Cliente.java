package Model;

public class Cliente {

    String CPF;
    String nome;
    int idade;
    double LimiteCredito;

    public Cliente(String CPF, String nome, int idade, double LimiteCredito){
        this.CPF= CPF;
        this.nome= nome;
        this.idade= idade;
        this.LimiteCredito= LimiteCredito;
    }

    public String getCPF(){
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getLimiteCredito() {
        return LimiteCredito;
    }
}
