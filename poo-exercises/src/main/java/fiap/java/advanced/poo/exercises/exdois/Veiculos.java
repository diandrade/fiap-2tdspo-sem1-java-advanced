package fiap.java.advanced.poo.exercises.exdois;

/**
 *
 * @author diandrade
 */
public class Veiculos {
    public static void main(String[] args)
    {
        Carro carro = new Carro();
        carro.acelerar();
        carro.mostrarVelocidade();
        
        Moto moto = new Moto();
        moto.acelerar();
        moto.mostrarVelocidade();
        
        Caminhao caminhao = new Caminhao();
        caminhao.acelerar();
        caminhao.mostrarVelocidade();
    }
}
