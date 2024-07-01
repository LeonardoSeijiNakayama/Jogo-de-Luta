package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EntradaTeclado implements KeyListener {
    public boolean cimaPress, esqPress, baixoPress, dirPress, socoPress;
    public int numPlayer;

    public EntradaTeclado(int n) {
        this.numPlayer = n;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyPressed(KeyEvent e) {
        if (this.numPlayer == 1) {
            int codigo = e.getKeyCode();

            if (codigo == KeyEvent.VK_W) {
                cimaPress = true;
            }
            if (codigo == KeyEvent.VK_A) {
                esqPress = true;
            }
            if (codigo == KeyEvent.VK_S) {
                baixoPress = true;
            }
            if (codigo == KeyEvent.VK_D) {
                dirPress = true;
            }
            if (codigo == KeyEvent.VK_T) {
                socoPress = true;
            }
        }else if(this.numPlayer == 2){
            int codigo = e.getKeyCode();

            if (codigo == KeyEvent.VK_UP) {
                cimaPress = true;
            }
            if (codigo == KeyEvent.VK_LEFT) {
                esqPress = true;
            }
            if (codigo == KeyEvent.VK_DOWN) {
                baixoPress = true;
            }
            if (codigo == KeyEvent.VK_RIGHT) {
                dirPress = true;
            }
            if (codigo == KeyEvent.VK_K) {
                socoPress = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.numPlayer == 1) {
            int codigo = e.getKeyCode();

            if (codigo == KeyEvent.VK_W) {
                cimaPress = false;
            }
            if (codigo == KeyEvent.VK_A) {
                esqPress = false;
            }
            if (codigo == KeyEvent.VK_S) {
                baixoPress = false;
            }
            if (codigo == KeyEvent.VK_D) {
                dirPress = false;
            }
            if (codigo == KeyEvent.VK_T) {
                socoPress = false;
            }
        }else if(this.numPlayer == 2){
            int codigo = e.getKeyCode();

            if (codigo == KeyEvent.VK_UP) {
                cimaPress = false;
            }
            if (codigo == KeyEvent.VK_LEFT) {
                esqPress = false;
            }
            if (codigo == KeyEvent.VK_DOWN) {
                baixoPress = false;
            }
            if (codigo == KeyEvent.VK_RIGHT) {
                dirPress = false;
            }
            if (codigo == KeyEvent.VK_K) {
                socoPress = false;
            }
        }
    }

}
