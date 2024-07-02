package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import Background.BackgroundManager;
import Main.Entidade.Player;
import Main.Entidade.Player2;
import Main.Tile.TileManager;

public class Painel extends JPanel implements Runnable{

    public final int tamTileOG = 32;
    public final int escala = 2;
    public final int tamTile = tamTileOG * escala; 
    public final int colMaxTela = 12;
    public final int linhaMaxTela = 20;
    public final int larguraMaxJanela = tamTile * linhaMaxTela;
    public final int alturaMaxJanela = tamTile * colMaxTela;

    int FPS = 60;

    EntradaTeclado teclado1 = new EntradaTeclado(1);
    EntradaTeclado teclado2 = new EntradaTeclado(2);
    Thread threadJogo;
    public ChecadorDeColisao checaCol = new ChecadorDeColisao(this);
    Player player = new Player(this, teclado1);
    Player2 player2 = new Player2(this, teclado2);
    TileManager tileManager = new TileManager(this);
    BackgroundManager backgroundManager = new BackgroundManager(this);


    
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
        this.addKeyListener(teclado1);
        this.addKeyListener(teclado2);
        this.setFocusable(true);
    }

    public void iniciaThreadJogo(){
        threadJogo = new Thread(this);
        threadJogo.start();
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
        player2.Update();
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        backgroundManager.draw(g2);
        tileManager.draw(g2);
        player.draw(g2);
        player2.draw(g2);
        
       
        g2.dispose();

    }
        
    }


