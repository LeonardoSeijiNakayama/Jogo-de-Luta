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
        larguraPlayer = 80 * p.escala;
        alturaPlayer = 128 * p.escala;
        //alturaAgachado = alturaPlayer/2;
        playerVelocidadeAgach = 5;
        agachado = false;
        direcao = "dir";
    }

    public void getImagemPlayer(){
        try {
            paradoDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoParadoDir.png"));
            paradoEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoParadoEsq.png"));
            paradoAgachadoDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoAgachadoParadoDir.png"));
            paradoAgachadoEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoAgachadoParadoEsq.png"));
            socoDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoSocoDir.png"));
            socoEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoSocoEsq.png"));
            puloDir = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoPulandoDir.png"));
            puloEsq = ImageIO.read(new FileInputStream("C:/Users/leona/Desktop/POO/testeJframe/res/personagems/leoPulandoEsq.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(){
        
        if(t.cimaPress == true && pulando == false){
            pulando = true;
            posicaoPuloInic = y;

            if(direcao == "esq"){
                direcao = "pulandoEsq";
            }else if(direcao == "dir"){
                direcao = "pulandoDir";
            }
            
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
                if(direcao == "pulandoDir"){
                    direcao = "dir";
                }else if(direcao == "pulandoEsq"){
                    direcao = "esq";
                }
                

            }

        }else{
            if(t.baixoPress == true && !agachado){
            agachado = true;
            if(direcao == "dir"){
                direcao = "agachadoDir";
            }else if(direcao == "esq"){
                direcao = "agachadoEsq";
            }
            
            velocidade = playerVelocidadeAgach;
            }else if(!t.baixoPress && agachado){
                agachado = false;
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

            case "agachadoDir":
                imagem = paradoAgachadoDir;
            break;
            
            case "agachadoEsq":
                imagem = paradoAgachadoEsq;
            break;

            case "pulandoDir":
                imagem = puloDir;
            break;

            case "pulandoEsq":
                imagem = puloEsq;
            break;  
        }

        g2.drawImage(imagem, x, y, larguraPlayer, alturaPlayer, null);

    }
}
