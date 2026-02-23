/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiap.java.advanced.poo.exercises.extres;

/**
 *
 * @author diandrade
 */
public class Triangulo {
    private double base;
    private double altura;
    private String cor;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea (){
        return base * altura / 2;
    }
    
    public String cor(String cor){
        this.cor = cor;
        return cor;
    }
}
