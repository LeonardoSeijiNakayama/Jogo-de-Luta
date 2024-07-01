package Main;

import Main.Entidade.Entidade;

public class ChecadorDeColisao {
    Painel pj;

    public ChecadorDeColisao(Painel pj) {
        this.pj = pj;
    }

    public void checaTile(Entidade entidade) {
        int entidadeEsqX = entidade.x + entidade.areaSolida.x;
        int entidadeDirX = entidade.x + entidade.areaSolida.x + entidade.areaSolida.width;
        int entidadeTopoY = entidade.y + entidade.areaSolida.y;
        int entidadeFundoY = entidade.y + entidade.areaSolida.y + entidade.areaSolida.height;

        int entidadeColunaEsq = entidadeEsqX / pj.tamTile;
        int entidadeColunaDir = entidadeDirX / pj.tamTile;
        int entidadeLinhaTopo = entidadeTopoY / pj.tamTile;
        int entidadeLinhaFundo = entidadeFundoY / pj.tamTile;

        int numTile1, numTile2;

        switch (entidade.direcao) {
            case "esq":
                entidadeColunaEsq = (entidadeEsqX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }

                break;

            case "dir":
                entidadeColunaDir = (entidadeDirX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }

                break;

            case "agachadoDir":
                entidadeColunaDir = (entidadeDirX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "agachadoEsq":
                entidadeColunaEsq = (entidadeEsqX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "pulandoDir":
                entidadeColunaDir = (entidadeDirX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaDir][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

            case "pulandoEsq":
                entidadeColunaEsq = (entidadeEsqX - entidade.velocidade) / pj.tamTile;
                numTile1 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaTopo];
                numTile2 = pj.tileManager.numTilesMapa[entidadeColunaEsq][entidadeLinhaFundo];

                if (pj.tileManager.tile[numTile1].colisao == true || pj.tileManager.tile[numTile2].colisao == true) {
                    entidade.colisao = true;
                }
                break;

        }
    }
}
