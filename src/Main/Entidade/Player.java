package Main.Entidade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import Main.EntradaTeclado;
import Main.Painel;

public class Player extends Entidade{
    Painel p;
    EntradaTeclado t;       

    boolean pulando;
    int posicaoPuloInic; 
    long tempoPuloInici;
    int duracaoMaxPulo ;
    int alturaMaxPulo ;
    int larguraPlayer ;
    int alturaPlayer ;
    int alturaAgachado ;
    int playerVelocidadeAgach ;
    boolean agachado;

    public Player(Painel p, EntradaTeclado t){
        this.p = p;
        this.t = t;
        setDefaultValues();
        getImagemPlayer();
        
    }

    public void setDefaultValues(){
        x = 500;
        y = 500;
        velocidade = 10;
        pulando = false;
        duracaoMaxPulo = 500;
        alturaMaxPulo = 300;
        larguraPlayer = p.tamTile*2;
        alturaPlayer = p.tamTile*4;
        alturaAgachado = alturaPlayer/2;
        playerVelocidadeAgach = 5;
        agachado = false;
        direcao = "dir";
    }

    public void getImagemPlayer(){
        try {
            paradoDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/lutadorParadoDir.png"));
            paradoEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/lutadorParadoEsq.png"));
            paradoAgachadoDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/lutadorParadoAgachadoDir.png"));
            paradoAgachadoEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/lutadorParadoAgachadoEsq.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(){
        
        if(t.cimaPress == true && pulando == false){
            pulando = true;
            posicaoPuloInic = y;
            
            tempoPuloInici = System.currentTimeMillis();
        }

        if(pulando) {
            long tempoAtual = System.currentTimeMillis();
            long duracaoPulo = tempoAtual - tempoPuloInici;
            double proporcaoTempoPulo = (double) duracaoPulo/duracaoMaxPulo;
            int alturaPulo = (int) (alturaMaxPulo * Math.sin(proporcaoTempoPulo * Math.PI));

            y = posicaoPuloInic - alturaPulo;

            if(duracaoPulo >= duracaoMaxPulo){
                pulando = false;
                y = posicaoPuloInic;
                

            }

        }else{
            if(t.baixoPress == true && !agachado){
            agachado = true;
            direcao = "agachado";
            alturaPlayer = alturaAgachado;
            velocidade = playerVelocidadeAgach;
            }else if(!t.baixoPress && agachado){
                agachado = false;
                alturaPlayer = p.tamTile*4;
                velocidade = 10;
            }
            
            else if(t.esqPress == true){
                direcao = "esq";
            x -= velocidade;

            }else if(t.dirPress == true){
                direcao = "dir";
            x += velocidade;

            }
        }

    }

    public void draw(Graphics2D g2){

       // g2.setColor(Color.white);
        //g2.fillRect(x, y, larguraPlayer, alturaPlayer);
        BufferedImage imagem = null;

        switch(direcao){
            case "esq": 
                imagem = paradoEsq;
                break;

            case "dir":
                imagem = paradoDir;
                break;
        }

        g2.drawImage(imagem, x, y, larguraPlayer, alturaPlayer, null);

    }
}
