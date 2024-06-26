package Main.Tile;

import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Painel;

public class TileManager {
    Painel pj;
    public Tile[] tile;
    public int[][] tiles;

    public TileManager(Painel pj){
        this.pj = pj;
        tile = new Tile[10];

        GetImagemTile();
    }

    public void GetImagemTile(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new FileInputStream("res/tiles/GrassTile.png"));
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    public void CarregaMapa(){

    }

    public void draw(Graphics2D g2){

        for(int i = 0; i < pj.larguraMaxJanela ; i++){
            if(i % 32 == 0){
                g2.drawImage(tile[0].image, i, 875, pj.tamTile, pj.tamTile, null);
            }
        }
        
    }

}
