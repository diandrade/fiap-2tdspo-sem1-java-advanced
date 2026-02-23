package fiap.java.advanced.poo.exercises.extres;

/**
 *
 * @author diandrade
 */
public class Quadrado {
    private double lado;
    private String cor;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    public double calcularArea (){
        return lado * lado;
    }
    
    public String cor(String cor){
        this.cor = cor;
        return cor;
    }
}
