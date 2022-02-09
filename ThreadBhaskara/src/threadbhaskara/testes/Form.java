package threadbhaskara.testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pjbie
 */
public class Form extends Thread{
    private int a;
    private int b;
    private int c;
    private int delta;
    private int x1;
    private int x2;

    public Form(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
  
	@Override
	public void run() {
		synchronized(this){ //entra em modo de sincronizacao
			System.out.println("Calculando Delta");
			try {
				this.delta=((b*b)-(4*a*c));
                                Form.sleep(2000);
			} catch(InterruptedException e) {
				System.out.println("Thread interrompida!!");
			}
			System.out.println("O Valor de Delta = "+ this.delta);
			notify(); //acorda uma thread que chamou wait
		}
	}

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
