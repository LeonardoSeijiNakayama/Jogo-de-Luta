package Main.Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.Painel;

public class TileManager {
    Painel pj;
    public Tile[] tile;
    public int[][] numTilesMapa;

    public TileManager(Painel pj){
        this.pj = pj;
        tile = new Tile[10];
        numTilesMapa = new int[pj.linhaMaxTela][pj.colMaxTela];
        
        GetImagemTile();
        CarregaMapa("res/mapas/mapaColisao.txt");
    }

    public void GetImagemTile(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new FileInputStream("res/tiles/EarthTile.png"));
            tile[0].colisao = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/tiles/GrassTile.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new FileInputStream("res/tiles/EarthTile.png"));

            tile[3] = new Tile();
            tile[3].image = null;
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    public void CarregaMapa(String caminhoMapa){
        try {
            File arquivoMapa = new File(caminhoMapa);
            FileReader fr = new FileReader(arquivoMapa);
            BufferedReader br = new BufferedReader(fr);

            int col = 0, linha = 0;

            while(col < pj.colMaxTela && linha < pj.linhaMaxTela){
                String linhaString = br.readLine();
                System.out.println(linhaString);
                while(linha < pj.linhaMaxTela){
                    String numeros[] = linhaString.split(" ");

                    int numero = Integer.parseInt(numeros[linha]);

                    numTilesMapa[linha][col] = numero;
                    linha++;
                    if(linha == (pj.linhaMaxTela)){
                        linha = 0;
                        col++;
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2){

        int col = 0, linha = 0, x =0, y =0;

        while(col < pj.colMaxTela  && linha < pj.linhaMaxTela){

            int numTile = numTilesMapa[linha][col];
            //System.out.println(numTile);
            
            g2.drawImage(tile[numTile].image, x, y, pj.tamTile, pj.tamTile, null);
            linha++;
            x +=pj.tamTile;

            if(linha == pj.linhaMaxTela){
                
                y += pj.tamTile;
                col++;
                linha = 0;
                x=0;
                
            }

            
            
        }
        

        for(int i = 0; i < pj.larguraMaxJanela ; i++){
            if(i % 32 == 0){
                g2.drawImage(tile[1].image, i, (pj.alturaMaxJanela-(2*pj.tamTile)), pj.tamTile, pj.tamTile, null);
                g2.drawImage(tile[2].image, i, (pj.alturaMaxJanela-pj.tamTile), pj.tamTile, pj.tamTile, null);
                
                
            }
            
        }
        
    }

}
