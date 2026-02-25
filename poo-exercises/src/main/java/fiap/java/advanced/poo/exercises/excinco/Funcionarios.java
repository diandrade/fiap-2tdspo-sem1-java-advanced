package fiap.java.advanced.poo.exercises.excinco;

/**
 *
 * @author diandrade
 */
public class Funcionarios {
    public static void main(String[] args){
        Funcionario func1 = new Funcionario("Juan De Oliveira", "Analista de Operações", 4000);
        Funcionario func2 = new Funcionario("Monique da Silva", "Engenheira de Software", 7000);
        Funcionario func3 = new Funcionario("Joanna Das Flores", "Jovem Aprendiz em TI", 9000);
        
        System.out.printf("%s\n", func1.toString());
        System.out.printf("%s\n", func2.toString());
        System.out.printf("%s\n", func3.toString());
        
        Gerente gen1 = new Gerente("Valdemira de Campos");
        Gerente gen2 = new Gerente("Julio Cesar");
        
        gen1.atualizar(func1, "Gerente de Operações");
        System.out.printf("%s\n", func1.toString());
        
        gen2.atualizar(func2, 9000);
        System.out.printf("%s\n", func1.toString());
    }
}
