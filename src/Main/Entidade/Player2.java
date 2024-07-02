package Main.Entidade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
//import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import Main.EntradaTeclado;
import Main.Painel;
//mport javax.scene.transform.AffineBuilder;

public class Player2 extends Entidade {
    Painel p;
    EntradaTeclado t;

    boolean pulando;
    int posicaoPuloInic;
    long tempoPuloInici;
    int duracaoMaxPulo;
    int alturaMaxPulo;
    int playerVelocidadeAgach;
    long tempoInicialSoco;
    long tempoMaxSoco;
    boolean agachado;
    boolean atacando;
    boolean andando;
    

    public Player2(Painel p, EntradaTeclado t) {
        this.p = p;
        this.t = t;
        
        setDefaultValues();
        getImagemPlayer();
        areaSolida = new Rectangle(8*p.escala, 20*p.escala, 47*p.escala, 108*p.escala);
        areaSoco = new Rectangle((45 * p.escala), (30 * p.escala), (35 * p.escala), (12 * p.escala));


        



    }

    public void setDefaultValues() {
        
           
        direcao = "esq";
        x = 850;
        y = (p.alturaMaxJanela - (p.tamTile * 6));
        velocidade = (int) (p.tamTile * 0.14);
        pulando = false;
        duracaoMaxPulo = 500;
        alturaMaxPulo = p.tamTile * 4;
        larguraEntidade = 80 * p.escala;
        alturaEntidade = 128 * p.escala;

        playerVelocidadeAgach = (int) (p.tamTile * 0.07);
        agachado = false;

        tempoInicialSoco = 0;
        tempoMaxSoco = 200;
        atacando = false;
        andando = false;
    }

    public void getImagemPlayer() {
        try {
            paradoDir = ImageIO.read(
                    new FileInputStream("res/personagems/leoParadoDir.png"));
            paradoEsq = ImageIO.read(
                    new FileInputStream("res/personagems/leoParadoEsq.png"));
            paradoAgachadoDir = ImageIO.read(
                    new FileInputStream("res/personagems/leoAgachadoParadoDir.png"));
            paradoAgachadoEsq = ImageIO.read(
                    new FileInputStream("res/personagems/leoAgachadoParadoEsq.png"));
            socoDir = ImageIO
                    .read(new FileInputStream("res/personagems/leoSocoDir.png"));
            socoEsq = ImageIO
                    .read(new FileInputStream("res/personagems/leoSocoEsq.png"));
            puloDir = ImageIO.read(
                    new FileInputStream("res/personagems/leoPulandoDir.png"));
            puloEsq = ImageIO.read(
                    new FileInputStream("res/personagems/leoPulandoEsq.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        // pular
        if (t.cimaPress == true && pulando == false && atacando == false) {
            pulando = true;
            posicaoPuloInic = y;

            if (direcao == "esq") {
                direcao = "pulandoEsq";
            } else if (direcao == "dir") {
                direcao = "pulandoDir";
            }

            tempoPuloInici = System.currentTimeMillis();
        }

        if (pulando) {
            long tempoAtual = System.currentTimeMillis();
            long duracaoPulo = tempoAtual - tempoPuloInici;
            double proporcaoTempoPulo = (double) duracaoPulo / duracaoMaxPulo;
            int alturaPulo = (int) (alturaMaxPulo * Math.sin(proporcaoTempoPulo * Math.PI));

            // if (direcao == "pulandoEsq" && andando) {
            // x -= velocidade;
            // } else if (direcao == "pulandoDir" && andando) {
            // x += velocidade;
            // }

            y = posicaoPuloInic - alturaPulo;

            if (duracaoPulo >= duracaoMaxPulo) {
                pulando = false;
                y = posicaoPuloInic;
                if (direcao == "pulandoDir") {
                    direcao = "dir";
                } else if (direcao == "pulandoEsq") {
                    direcao = "esq";
                }
            }
        } else {
            // socar
            if (t.socoPress && !pulando && !agachado && !atacando && !andando) {
                atacando = true;
                tempoInicialSoco = System.currentTimeMillis();
                if (direcao == "dir") {
                    direcao = "socoDir";
                } else if (direcao == "esq") {
                    direcao = "socoEsq";
                }
            } else if (t.socoPress && !pulando && !agachado && !atacando && t.dirPress && andando) {
                atacando = true;
                tempoInicialSoco = System.currentTimeMillis();
                direcao = "socoDir";
            }

            if (atacando) {
                long tempoDecorridoSoco = System.currentTimeMillis() - tempoInicialSoco;

                if (tempoDecorridoSoco >= tempoMaxSoco) {
                    atacando = false;
                    if (direcao == "socoDir") {
                        direcao = "dir";
                    } else if (direcao == "socoEsq") {
                        direcao = "esq";
                    }
                }
            }

            // agachar
            else if (t.baixoPress == true && !agachado) {
                agachado = true;
                if (direcao == "dir") {
                    direcao = "agachadoDir";
                } else if (direcao == "esq") {
                    direcao = "agachadoEsq";
                }

                velocidade = playerVelocidadeAgach;
            } else if (!t.baixoPress && agachado) {
                agachado = false;
                if (direcao == "agachadoDir") {
                    direcao = "dir";
                } else if (direcao == "agachadoEsq") {
                    direcao = "esq";
                }
                velocidade = (int) (p.tamTile * 0.14);
            }

            // mover para esquerda
            if (t.esqPress) {
                if (agachado) {
                    direcao = "agachadoEsq";
                } else {
                    direcao = "esq";
                }
                andando = true;

            }
            // mover para direita
            else if (t.dirPress) {
                if (agachado) {
                    direcao = "agachadoDir";
                } else {
                    direcao = "dir";
                }
                andando = true;

            } else if (!t.dirPress && !t.esqPress) {
                andando = false;

            }
        }

        colisao = false;
        p.checaCol.checaTile(this);

        if (colisao == false && andando == true || colisao == false && pulando == true) {
            switch (direcao) {
                case "esq":
                    x -= velocidade;
                    break;

                case "dir":
                    x += velocidade;
                    break;

                case "agachadoDir":
                    x += playerVelocidadeAgach;
                    break;

                case "agachadoEsq":
                    x -= playerVelocidadeAgach;
                    break;

                case "pulandoDir":
                    if(andando){
                        x += velocidade;
                    }
                    
                    break;

                case "pulandoEsq":
                if(andando){
                    x -= velocidade;
                }
                    
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, larguraPlayer, alturaPlayer);
        BufferedImage imagem = null;
        AffineTransform transform = new AffineTransform();
        double escalapulo;

        escalapulo = ((double) p.escala * 0.15) / 2;

        switch (direcao) {
            case "esq":
                imagem = paradoEsq;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);
                break;

            case "dir":
                imagem = paradoDir;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);

              

                break;

            case "agachadoDir":
                imagem = paradoAgachadoDir;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);
                break;

            case "agachadoEsq":
                imagem = paradoAgachadoEsq;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);
                break;

            case "pulandoDir":
                imagem = puloDir;
                transform.translate(x, y);
                transform.scale(escalapulo, escalapulo);
                transform.rotate(Math.toRadians(25), imagem.getWidth() / 2, imagem.getHeight() / 2);
                g2.drawImage(imagem, transform, null);
                break;

            case "pulandoEsq":
                imagem = puloEsq;
                transform.translate(x, y);
                transform.scale(escalapulo, escalapulo);
                transform.rotate(Math.toRadians(-15), imagem.getWidth() / 2, imagem.getHeight() / 2);
                g2.drawImage(imagem, transform, null);
                break;
            case "socoDir":
                imagem = socoDir;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);

                break;
            case "socoEsq":
                imagem = socoEsq;
                g2.drawImage(imagem, x, y, larguraEntidade, alturaEntidade, null);
                break;
        }

        int entidadeDirXEsq = x + areaSolida.x;
        int entidadeDirXDir = x + areaSolida.x + areaSolida.width;

        int entidadeEsqXEsq = x + (larguraEntidade - (areaSolida.width + areaSolida.x));
        int entidadeEsqXDir = x + larguraEntidade -areaSolida.x;

        int entidadeTopoY = y + areaSolida.y;
        int entidadeFundoY = y + areaSolida.y + areaSolida.height;

        int entidadeSocoDirXEsq = x + larguraEntidade - areaSoco.width;
        int entidadeSocoDirXDir = x + larguraEntidade;

        int entidadeSocoEsqXEsq = x ;
        int entidadeSocoEsqXDir = x + areaSoco.width;

        int entidadeSocoTopoY = y + areaSoco.y;
        int entidadeSocoFundoY = y + areaSoco.y + areaSoco.height;

        g2.setColor(Color.RED);

        switch(direcao){
            case "dir": 
                g2.drawRect(entidadeDirXEsq, entidadeTopoY, areaSolida.width, areaSolida.height);
                g2.drawRect(entidadeSocoDirXEsq,entidadeSocoTopoY , areaSoco.width, areaSoco.height);
                
            break;
            case "esq":
                g2.drawRect(entidadeEsqXEsq, entidadeTopoY, areaSolida.width, areaSolida.height);
                g2.drawRect(entidadeSocoEsqXEsq,entidadeSocoTopoY , areaSoco.width, areaSoco.height);
                break;

            case "socoDir":
                if(efeito == true){
                    g2.drawRect(entidadeSocoDirXEsq + 20, entidadeSocoTopoY, areaSoco.width - 25 , areaSoco.height);
                }
            break;
        }

        
        

    }
}
