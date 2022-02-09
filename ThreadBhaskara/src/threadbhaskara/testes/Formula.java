/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadbhaskara.testes;

/**
 *
 * @author pjbie
 */
public final class Formula {
   /*0  Formula
     
            -b±√▲
         X=  --------
              -2b
    
    Formula delta
            
            ▲=b²-4ac
    
    ▲>0 = 2 raizes diferentes
    ▲<0 nao exintem raizes
    ▲=0 duas raizes iguais
    */
    private int a;
    private int b;
    private int c;
    private int delta;
    private int x1;
    private int x2;

    public Formula() {
    }

    
    public Formula(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        formulaDelta(a, b, c);
        formulaX(a, b, c);
    }

    
    public int formulaDelta(int a, int b, int c) {
        return this.delta=((b*b)-(4*a*c));
    }

  

    public void formulaX(int a, int b, int c) {
       
        formulaDelta(a, b, c);
        this.x1= ((int) (-(b)+ Math.sqrt(getDelta())))/(2*a);
        this.x2= ((int) (-(b)- Math.sqrt(getDelta())))/(2*a);
       
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
