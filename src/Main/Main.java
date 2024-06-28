package Main;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setTitle("Janela");

        Painel painel = new Painel();
        janela.add(painel);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        

        painel.iniciaThreadJogo();
    }
}
