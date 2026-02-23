package fiap.java.advanced.poo.exercises.exdois;

/**
 *
 * @author diandrade
 */
public class Caminhao extends Veiculo {
    
    @Override
    public void mostrarVelocidade() {
        super.mostrarVelocidade();
        System.out.printf("A velocidade atual de meu caminhão é: %s.\n", getVelocidade());
    }

    @Override
    public void acelerar() {
        super.acelerar();
        setVelocidade(getVelocidade() + 5);
    }
}
