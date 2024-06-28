package Main;

import Main.Entidade.Entidade;

public class ChecadorDeColisao {
    Painel pj;

    public ChecadorDeColisao(Painel pj){
        this.pj = pj;
    }

    public void checaTile(Entidade entidade){
        int entidadeEsqX = entidade.x + entidade.areaSolida.x;
        int entidadeDirX = entidade.x + entidade.areaSolida.x + entidade.areaSolida.width;
        int entidadeTopoY =  entidade.y + entidade.areaSolida.y;
        int entidadeFundoY = entidade.y + entidade.areaSolida.y+entidade.areaSolida.height;

        int entidadeColunaEsq = entidadeEsqX/pj.tamTile;
        int entidadeColunaDir = entidadeDirX/pj.tamTile;
        int entidadeLinhaTopo = entidadeTopoY/pj.tamTile;
        int entidadeLinhaFundo = entidadeFundoY/pj.tamTile;
        

        int numTile1, numTile2;

        switch (entidade.direcao) {
            case "esq":
                    entidadeLinhaTopo = (entidadeTopoY - entidade.velocidade)/pj.tamTile;
                    
                break;

            case "dir":
                
                break;

            case "agachadoDir":
                
                break;

            case "agachadoEsq":
                
                break;

            case "pulandoDir":
               
                break;

            case "pulandoEsq":
                
                break;
            
        }
    }
}
