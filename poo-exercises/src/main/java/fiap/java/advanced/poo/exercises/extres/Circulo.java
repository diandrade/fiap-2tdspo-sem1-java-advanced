package fiap.java.advanced.poo.exercises.extres;

/**
 *
 * @author diandrade
 */
public class Circulo {
    private double raio;
    private String cor;

    public Circulo(int raio) {
        this.raio = raio;
    }

    public double calcularArea (){
        return Math.PI * Math.pow(raio, 2);
    }
    
    public String cor(String cor){
        this.cor = cor;
        return cor;
    }
}
