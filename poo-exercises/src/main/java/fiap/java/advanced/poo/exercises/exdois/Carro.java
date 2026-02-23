package fiap.java.advanced.poo.exercises.exdois;

/**
 *
 * @author diandrade
 */
public class Carro extends Veiculo {
    
    @Override
    public void mostrarVelocidade() {
        super.mostrarVelocidade();
        System.out.printf("A velocidade atual de meu carro é: %s.\n", getVelocidade());
    }

    @Override
    public void acelerar() {
        super.acelerar();
        setVelocidade(getVelocidade() + 10);
    }
}
