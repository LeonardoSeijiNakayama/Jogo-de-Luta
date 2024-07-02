package Main.Entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {
    public int x, y;
    public int velocidade;
    public int larguraEntidade;
    public int alturaEntidade;
    public int alturaEntidadeAgachado;

    public BufferedImage paradoDir, paradoEsq, paradoAgachadoDir, paradoAgachadoEsq, socoDir, socoEsq, puloDir, puloEsq;
    public String direcao;

    public Rectangle areaSolida;
    public Rectangle areaSoco;
    public boolean colisao = false;
    public boolean socoColisao = false;
    public boolean efeito = false;
}
