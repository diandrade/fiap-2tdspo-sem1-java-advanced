package fiap.java.advanced.poo.exercises.excinco;

/**
 *
 * @author labsfiap
 */
public class Funcionario {
    public String nome;
    public String cargo;
    public double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + '}';
    }
}
