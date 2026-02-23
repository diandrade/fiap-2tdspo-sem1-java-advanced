/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiap.java.advanced.poo.exercises.extres;

/**
 *
 * @author diandrade
 */
public class Retangulo {
    private double largura;
    private double altura;
    private String cor;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularArea (){
        return largura * altura;
    }
    
    public String cor(String cor){
        this.cor = cor;
        return cor;
    }
}
