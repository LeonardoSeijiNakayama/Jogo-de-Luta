package Main;



import Main.Entidade.Entidade;

public class ChecadorDeColisao {
    Painel pj;

    public ChecadorDeColisao(Painel pj) {
        this.pj = pj;
    }

    public void checaTile(Entidade entidade) {

        //CALCULOS DA AREA DE COLISAO DO PPLAYER

        int entidadeDirXEsq = entidade.x + entidade.areaSolida.x;
        int entidadeDirXDir = entidade.x + entidade.areaSolida.x + entidade.areaSolida.width;

        int entidadeEsqXEsq = entidade.x + (entidade.larguraEntidade - (entidade.areaSolida.width + entidade.areaSolida.x));
        int entidadeEsqXDir = entidade.x + entidade.larguraEntidade - entidade.areaSolida.x;

        int entidadeTopoY = entidade.y + entidade.areaSolida.y;
        int entidadeFundoY = entidade.y + entidade.areaSolida.y + entidade.areaSolida.height;

        int entidadeDirColunaEsq = entidadeDirXEsq / pj.tamTile;
        int entidadeDirColunaDir = entidadeDirXDir / pj.tamTile;

        int entidadeEsqColunaEsq = entidadeEsqXEsq / pj.tamTile;
        int entidadeEsqColunaDir = entidadeEsqXDir / pj.tamTile;

        int entidadeLinhaTopo = entidadeTopoY / pj.tamTile;
        int entidadeLinhaFundo = entidadeFundoY / pj.tamTile;

        int numTile1, numTile2;

        switch (entidade.direcao) {
            case "esq":
                entidadeEsqColunaEsq = (entidadeEsqXEsq - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaFundo];
                

               

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }

                break;

            case "dir":
                entidadeDirColunaDir = (entidadeDirXDir - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }

                break;

            case "agachadoDir":
                entidadeDirColunaDir = (entidadeDirXDir - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "agachadoEsq":
                entidadeEsqColunaEsq = (entidadeEsqXEsq - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "pulandoDir":
                entidadeDirColunaDir = (entidadeDirXDir - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeDirColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "pulandoEsq":
                entidadeEsqColunaEsq = (entidadeEsqXEsq - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeEsqColunaEsq][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            
        }

        
    }

    
   
}
