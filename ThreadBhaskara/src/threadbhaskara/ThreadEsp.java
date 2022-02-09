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
public class ThreadEsp implements Runnable {//implementando threads

    FormulasEsp Formulas = new FormulasEsp();//instanciando a classe formulas
    Thread threadf;//variavel thread
    private boolean saida;//varial para testar o sincronismo

    public ThreadEsp(String nome, FormulasEsp f) {//construtor recebendo um nome e uma instancia de formulas
        this.Formulas = f;//instancia de formulas
        threadf = new Thread(this, nome); //criando uma nova thread no construtor
       // saida = false;//setando como false ate que seja true para parar
    }

    @Override
    public void run() {
        //while (!saida) {teste pra gerar a mesma thread pra ver o escalonamento
        //so funciona se deixa somente as thread no main, o System.out.prints
        //para deixar mais bonito rodam em outra thread pra ficar perfeito teria que cria um 3 metodo sinconizado 
        //pra tela de apresentação 

        try {

            if (threadf.getName().equals("delta")) {//compara o nome depois exeulta uma forma de assegurar mais a execução
                Formulas.ExecDelta(true);//aqui libera para entrar no while do metodo ExecDelta setando a variavel de exclusao mutua
                Formulas.ExecDelta(false);//seto false para dizer que esta livre a zona critica

            } else {
                Formulas.calculandoX(true);//seta como verdadeiro dizendo que estalivre a zona critica agora posso calcular

            }

        } catch (Exception e) {
            System.out.println("Thread interrompida");
        } finally {
            Thread.currentThread().interrupt();//interromper so quando fiz os teste de criar sequencialmente

        }

       // }
    }

    synchronized boolean
            isSaida() {
        return saida;
    }

    public void setSaida(boolean saida) {
        this.saida = saida;
    }

}
