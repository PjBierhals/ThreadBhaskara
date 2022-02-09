/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadbhaskara;

/**
 *
 * @author pjbie
 */
public class FormulasEsp {

    boolean ExecDelta; //variavel a ser compartilhada para exclusao mutua

    //variaveis para executar o codigo
    private int a;
    private int b;
    private int c;
    private int delta;
    private int x1;
    private int x2;

    //construtor vazio
    public FormulasEsp() {
    }
//contrutor passando variaveis para calculo
    public FormulasEsp(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //metodo sincronizado para execultar conforme variavel de exclusão mutua os dois metodo tem as mesma especificação
    synchronized void ExecDelta(boolean estaOcupado) {
        ///para teste sequenciais eu fiz
        if (!estaOcupado) { //se ocupado for false
            ExecDelta = true;//decide se a thread esta na zona citica
            notify();//faz a notificação
            return;
        }

        try {
            while (ExecDelta) { //enquanto esta na zona critica espere a notyficação
                wait();

            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida");
        }
        //resolução da equação apos o problema
        this.delta = ((b * b) - (4 * a * c));
        System.out.println("==============================Fórmula Delta==================================");
        System.out.println("");
        System.out.println("                                  ▲=b²-4ac");
        System.out.println("");
        System.out.println("==============================================================================");

        System.out.println("Valor de Delta ▲ = " + getDelta());

        notify();//notifica
    }

    synchronized void calculandoX(boolean estaOcupado) {

        if (!estaOcupado) {

            ExecDelta = false;//so execulta se a zona critica estiver livre
            notify();

        }

        try {
            while (!ExecDelta) {
                wait();

            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida");
        }

        this.x1 = ((int) (-(b) + Math.sqrt(getDelta()))) / (2 * a);
        this.x2 = ((int) (-(b) - Math.sqrt(getDelta()))) / (2 * a);
        System.out.println("====================================Fórmula===================================");
        System.out.println("");
        System.out.println("                                     -b±√▲");
        System.out.println("                                   X=-------");
        System.out.println("                                       -2b ");
        System.out.println("");
        System.out.println("==============================================================================");
        System.out.println("Valor de Delta X¹ = " + getX1());
        System.out.println("Valor de Delta X² = " + getX2());
        notify();
    }
    
    //metodo de aplicação para apresentação da equação
    public String sinal(int numero) {

        if (numero > 0) {//se o numero for positivo
           return " +" + Integer.toString(numero);//acresenta o sinal de +
        }
        return Integer.toString(numero);//retorna sinal -
    }
    //metodos get e set
    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

  

}
