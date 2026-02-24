package fiap.java.advanced.poo.exercises.exquatro;

/**
 *
 * @author labsfiap
 */
public class Imoveis {
    public static void main(String[] args)
    {
        NovoImovel im1 = new NovoImovel("Rua Bartolomeu Ferrari, 780", 
                100000, 5000);
        
        VelhoImovel im2 = new VelhoImovel("Rua Bartolomeu Ferrari, 780", 
                100000, 5000);
        im1.valorDoImovel();
        im2.valorDoImovel();
    }
}
