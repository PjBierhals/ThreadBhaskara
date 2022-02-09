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
public class ThreadBhaskara {

    /**
     */
    public static void main(String[] args) {

       // FormulasEsp f = new FormulasEsp(2, 12, -14);//Instancia que passa os números para calcular
      FormulasEsp f = new FormulasEsp(1, 5, 6);//Funções teste é so comentar a ativa e descomentar a de teste
        //FormulasEsp f = new FormulasEsp(-2, 12, -14);
        //FormulasEsp f = new FormulasEsp(-3, 10, -3);
        ThreadEsp delta = new ThreadEsp("delta", f);//crio uma instancia da minha classe thread dando um nome e passando as formulas
        ThreadEsp x = new ThreadEsp("xx", f);//segunda thread
        //melhororando a aparência

        System.out.println("==============================================================================");
        System.out.println("==============Exclusão Multua & Multithreading===============================");
        System.out.println("==============================================================================");
        //montando a função
        System.out.println("Por exemplo, dada a equação " + f.getA() + "x²"
                + f.sinal(f.getB()) + "x "
                + f.sinal(f.getC()) + " = 0, calcule o valor de Δ, x¹ e x².");
        System.out.println("==============================================================================");
        System.out.print("Valor de a = " + f.getA() + "  |  ");
        System.out.print("Valor de b = " + f.getB() + "  |  ");
        System.out.println("Valor de c = " + f.getC());
        System.out.println("==============================================================================");
        delta.threadf.start();//startando a thread
        x.threadf.start();//startando a thread

        try {

            delta.threadf.join();//assegurando que a thread execulte corretamente esperando seu fim

            x.threadf.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrompida");

        }
        System.out.println("!!!!!!!!!!!!!!!!!!              This is the end Threads!          !!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!                \"the comments lie!\"             !!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!              Robert Martin (Uncle Bob)         !!!!!!!!!!!!!!!!!!");

    }

}
