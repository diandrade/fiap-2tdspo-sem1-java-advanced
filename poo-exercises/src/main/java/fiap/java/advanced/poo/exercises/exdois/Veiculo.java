package fiap.java.advanced.poo.exercises.exdois;

/**
 *
 * @author diandrade
 */
public class Veiculo {
    private String placa;
    private String cor;
    private double preco;
    private String proprietario;
    private double velocidade = 0;

    public double getVelocidade() {
        return velocidade;
    }    

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    
    
    public void acelerar(){};
    
    public void mostrarVelocidade(){}
}


