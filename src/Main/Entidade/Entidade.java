package Main.Entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {
    public int x, y;
    public int velocidade;

    public BufferedImage paradoDir, paradoEsq, paradoAgachadoDir, paradoAgachadoEsq, socoDir, socoEsq, puloDir, puloEsq;
    public String direcao;

    public Rectangle areaSolida;
    public boolean colisao = false;
}
