/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadbhaskara.testes;

import threadbhaskara.testes.Formula;

/**
 *
 * @author pjbie
 */
public class MinhasThreads implements Runnable{

    private int a;
    private int b;
    private int c;
    private int delta;
    private int x1;
    private int x2;
    private static Formula formula = new Formula();

    public MinhasThreads() {
     new Thread(this).start();
    }

    public MinhasThreads(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        new Thread(this).start();
    }
    
    
    
    @Override
    public void run() {
        this.delta= formula.formulaDelta(a, b, c);
        System.out.println("O Valor de Delta = "+ this.delta);
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

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
    
}
