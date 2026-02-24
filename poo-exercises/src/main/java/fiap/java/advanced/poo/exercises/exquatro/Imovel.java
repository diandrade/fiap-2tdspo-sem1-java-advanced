package fiap.java.advanced.poo.exercises.exquatro;

/**
 *
 * @author labsfiap
 */
public class Imovel {
    final private String endereco;
    private double preco;

    public Imovel(String endereco, double preco) {
        this.endereco = endereco;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
