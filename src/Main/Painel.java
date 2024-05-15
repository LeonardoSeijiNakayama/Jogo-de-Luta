package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

import Main.Entidade.Player;

public class Painel extends JPanel implements Runnable{

    public final int tamTileOG = 32;
    public final int escala = 3;
    public final int tamTile = tamTileOG * escala; 
    public final int colMaxTela = 12;
    public final int linhaMaxTela = 18;
    public final int larguraMaxJanela = tamTile * linhaMaxTela;
    public final int alturaMaxJanela = tamTile * colMaxTela;

    int FPS = 60;

    EntradaTeclado teclado = new EntradaTeclado();
    Thread threadJogo;
    Player player = new Player(this, teclado);


    int playerX = 500;
    int playerY = 500;
    int playerVelocidade = 10;
    boolean pulando;
    int posicaoPuloInic; 
    long tempoPuloInici;
    int duracaoMaxPulo = 500;
    int alturaMaxPulo = 200;
    int larguraPlayer = tamTile*2;
    int alturaPlayer = tamTile*4;
    int alturaAgachado = alturaPlayer/2;
    int playerVelocidadeAgach = 5;
    boolean agachado;

    public Painel(){
        this.setPreferredSize(new Dimension(larguraMaxJanela, alturaMaxJanela));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true);
        this.setVisible(true);
        this.addKeyListener(teclado);
        this.setFocusable(true);
    }

    public void iniciaThreadJogo(){
        threadJogo = new Thread(this);
        threadJogo.start();
    }

    public void carregaImagem(){

    }

    @Override
    public void run() {

        double intervaloDesenho = 1000000000/FPS;
        double delta = 0;
        long ultimoTempo = System.nanoTime();
        long tempoAtual;

        while(threadJogo != null){

            tempoAtual = System.nanoTime();

            delta += (tempoAtual - ultimoTempo) / intervaloDesenho;
            ultimoTempo = tempoAtual;

            if(delta > 1){

                update();
                repaint();
                delta--;
            }
            

        }
        
    }

    public void update(){
        player.Update();
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
       
        g2.dispose();

    }
        
    }


