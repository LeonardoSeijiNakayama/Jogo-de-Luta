package Background;

import java.awt.Graphics2D;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import Main.Painel;

public class BackgroundManager {
    Painel pj;
    Background background[];
    public BackgroundManager(Painel pj){
        this.pj = pj;
        background = new Background[10];
        CarregaIMGBackground();
        
    }

    public void CarregaIMGBackground(){
        try {
            background[0] = new Background();
            background[0].img = ImageIO.read(new FileInputStream("res/backgrounds/BackgroundSkyV1.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public void draw(Graphics2D g2){
        g2.drawImage(background[0].img, 0, 0, pj.larguraMaxJanela, pj.alturaMaxJanela, null );
    }
}
