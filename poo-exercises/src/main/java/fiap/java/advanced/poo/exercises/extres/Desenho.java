package fiap.java.advanced.poo.exercises.extres;

/**
 *
 * @author diandrade
 */
public class Desenho {
    public static void main (String[]args){
        Quadrado q = new Quadrado(10);
        System.out.printf("A Área do Quadrado é %s.\n", q.calcularArea());
        System.out.printf("A Cor do Quadrado é %s.\n", q.cor("Azul"));
        System.out.println();
        
        Retangulo r = new Retangulo(10, 5);
        System.out.printf("A Área do Retângulo é %s.\n", r.calcularArea());
        System.out.printf("A Cor do Retângulo é %s.\n", r.cor("Preto"));
        System.out.println();
        
        Triangulo t = new Triangulo(10, 5);
        System.out.printf("A Área do Triangulo é %s.\n", t.calcularArea());
        System.out.printf("A Cor do Triangulo é %s.\n", t.cor("Amarelo"));
        System.out.println();
        
        Circulo c = new Circulo(10);
        System.out.printf("A Área do Circulo é %s.\n", t.calcularArea());
        System.out.printf("A Cor do Circulo é %s.\n", t.cor("Vermelho"));
    }
}
