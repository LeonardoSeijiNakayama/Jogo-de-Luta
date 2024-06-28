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
            tile[0].image = null;
            tile[0].colisao = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/tiles/GrassTile.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new FileInputStream("res/tiles/EarthTile.png"));
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    public void CarregaMapa(){

    }

    public void draw(Graphics2D g2){

        int col = 0, linha = 0, x =0, y =0;

        while(col <= pj.alturaMaxJanela && linha < pj.larguraMaxJanela){
            g2.drawImage(tile[0].image, x, y, pj.tamTile, pj.tamTile, null);
            col++;
            x +=pj.tamTile;

            if(col == pj.alturaMaxJanela){
                
                y += pj.tamTile;
                linha++;
                col = 0;
                x=0;
                
            }

            
            
        }


        for(int i = 0; i < pj.larguraMaxJanela ; i++){
            if(i % 32 == 0){
                g2.drawImage(tile[1].image, i, 800, pj.tamTile, pj.tamTile, null);
                g2.drawImage(tile[2].image, i, 864, pj.tamTile, pj.tamTile, null);
                g2.drawImage(tile[0].image, -86, i, pj.tamTile, pj.tamTile, null);
                g2.drawImage(tile[0].image, 1718, i, pj.tamTile, pj.tamTile, null);
                
            }
            
        }
        
    }

}
